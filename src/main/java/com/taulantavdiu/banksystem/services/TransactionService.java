package com.taulantavdiu.banksystem.services;

import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.Transaction;

import java.util.UUID;

public interface TransactionService {

    Transaction addTransaction(Transaction transaction);

    Account withdraw(Transaction transaction, UUID accountId);

    Account deposit(Transaction transaction, UUID accountId);


}
