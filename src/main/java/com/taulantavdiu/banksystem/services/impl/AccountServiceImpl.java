package com.taulantavdiu.banksystem.services.impl;

import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.Bank;
import com.taulantavdiu.banksystem.repositories.AccountRepository;
import com.taulantavdiu.banksystem.repositories.BankRepository;
import com.taulantavdiu.banksystem.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final BankRepository bankRepository;

    @Override
    public Account save(Account account, UUID bankId) {
        Bank bank = bankRepository.findById(bankId).orElseThrow(() -> new EntityNotFoundException("Bank with id " + bankId + " not found"));

         account.setBank(bank);
         account.setBalance(BigDecimal.ZERO);

         return accountRepository.save(account);
    }

    @Override
    public Account findById(UUID id) {
        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account with id " + id + " not found"));
    }

    @Override
    public List<Account> findByBankId(UUID id) {

        var exists = bankRepository.existsById(id);

        if (!exists) {
            throw new EntityNotFoundException("Bank with id " + id + " not found");
        }

        return accountRepository.findByBankId(id);
    }
}
