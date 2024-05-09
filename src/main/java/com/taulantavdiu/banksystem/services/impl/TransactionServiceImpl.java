package com.taulantavdiu.banksystem.services.impl;

import com.taulantavdiu.banksystem.exceptions.BadRequestException;
import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.Bank;
import com.taulantavdiu.banksystem.models.Transaction;
import com.taulantavdiu.banksystem.models.TransactionType;
import com.taulantavdiu.banksystem.repositories.AccountRepository;
import com.taulantavdiu.banksystem.repositories.TransactionRepository;
import com.taulantavdiu.banksystem.services.TransactionService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;


    @Override
    @Transactional
    public Transaction addTransaction(Transaction transaction) {
        Account sender = accountRepository.findById(transaction.getSender().getId()).orElseThrow(()-> new EntityNotFoundException("Account with id " + transaction.getSender().getId() + " not found"));
        Account receiver = accountRepository.findById(transaction.getReceiver().getId()).orElseThrow(()-> new EntityNotFoundException("Account with id " + transaction.getReceiver().getId() + " not found"));

        handleFee(transaction, sender);

        if (sender.getBalance().compareTo(transaction.getAmount()) < 0) {
            throw new BadRequestException("You don't have enough funds to make this transaction");
        }


        sender.setBalance(sender.getBalance().subtract(transaction.getAmount()));
        receiver.setBalance(receiver.getBalance().add(transaction.getAmount()));

        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public Account withdraw(Transaction transaction, UUID accountId) {

        Account account = accountRepository.findById(accountId).orElseThrow(()-> new EntityNotFoundException("Account with id " + accountId + " not found"));

        if (account.getBalance().compareTo(transaction.getAmount()) < 0) {
            throw new BadRequestException("Insufficient funds");
        }

        transaction.setType(TransactionType.WITHDRAW);
        transaction.setSender(account);
        transaction.setReceiver(account);

        account.setBalance(account.getBalance().subtract(transaction.getAmount()));

        return transactionRepository.save(transaction).getSender();
    }

    @Override
    @Transactional
    public Account deposit(Transaction transaction, UUID accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(()-> new EntityNotFoundException("Account with id " + accountId + " not found"));

        transaction.setType(TransactionType.DEPOSIT);
        transaction.setSender(account);
        transaction.setReceiver(account);

        Bank bank = account.getBank();

        bank.setTotalTransfer(bank.getTotalTransfer().add(transaction.getAmount()));

        account.setBalance(account.getBalance().add(transaction.getAmount()));

        return transactionRepository.save(transaction).getSender();

    }

    private void handleFee(Transaction transaction, Account sender) {
        Bank senderBank = sender.getBank();

        if (transaction.getType() == TransactionType.FLAT_FEE_TRANSFER) {
            sender.setBalance(sender.getBalance().subtract(senderBank.getFlatFee()));
            senderBank.setTotalFee(senderBank.getTotalFee().add(senderBank.getFlatFee()));
        }

        if (transaction.getType() == TransactionType.PERCENT_FEE_TRANSFER) {
            BigDecimal fee = senderBank.getPercentFee().multiply(transaction.getAmount()).divide(new BigDecimal(100));
            sender.setBalance(sender.getBalance().subtract(fee));
            senderBank.setTotalFee(senderBank.getTotalFee().add(fee));
        }

        senderBank.setTotalTransfer(senderBank.getTotalTransfer().add(transaction.getAmount()));

    }
}
