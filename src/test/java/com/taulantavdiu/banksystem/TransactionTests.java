package com.taulantavdiu.banksystem;

import com.taulantavdiu.banksystem.exceptions.BadRequestException;
import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.Transaction;
import com.taulantavdiu.banksystem.repositories.AccountRepository;
import com.taulantavdiu.banksystem.repositories.TransactionRepository;
import com.taulantavdiu.banksystem.services.TransactionService;
import com.taulantavdiu.banksystem.services.impl.TransactionServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionTests {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    public void testAddTransaction_NotEnoughFunds() {

        Account sender = Account.builder().id(UUID.randomUUID()).balance(BigDecimal.TEN).build();


        Transaction transaction = Transaction.builder()
                .amount(BigDecimal.valueOf(20))
                .sender(sender)
                .receiver(sender)
                .build();

        when(accountRepository.findById(sender.getId())).thenReturn(Optional.of(sender));

        assertThrows(BadRequestException.class, () -> transactionService.addTransaction(transaction));
    }

    @Test
    public void testAddTransaction_AccountNotFound(){
        Account sender = Account.builder().id(UUID.randomUUID()).balance(BigDecimal.TEN).build();

        Transaction transaction = Transaction.builder()
                .amount(BigDecimal.valueOf(5))
                .sender(sender)
                .receiver(Account.builder().id(UUID.randomUUID()).build())
                .build();

        when(accountRepository.findById(sender.getId())).thenReturn(Optional.of(sender));

        assertThrows(EntityNotFoundException.class, () -> transactionService.addTransaction(transaction));
    }

    @Test
    public void testAddTransaction_SuccessfulTransaction(){
        Account sender = Account.builder().id(UUID.randomUUID()).balance(BigDecimal.TEN).build();
        Account receiver = Account.builder().id(UUID.randomUUID()).balance(BigDecimal.ZERO).build();

        Transaction transaction = Transaction.builder()
                .amount(BigDecimal.valueOf(5))
                .sender(sender)
                .receiver(receiver)
                .build();

        when(accountRepository.findById(sender.getId())).thenReturn(Optional.of(sender));
        when(accountRepository.findById(receiver.getId())).thenReturn(Optional.of(receiver));
        when(transactionRepository.save(transaction)).thenReturn(transaction);

        Transaction result = transactionService.addTransaction(transaction);

        assert sender.getBalance().compareTo(BigDecimal.valueOf(5)) == 0;
        assert receiver.getBalance().compareTo(BigDecimal.valueOf(5)) == 0;
        assertNotNull(result.getSender());
        assertEquals(result.getAmount(),BigDecimal.valueOf(5));
    }
}
