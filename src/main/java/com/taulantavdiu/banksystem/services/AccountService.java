package com.taulantavdiu.banksystem.services;

import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.Bank;
import com.taulantavdiu.banksystem.models.Transaction;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account save(Account account, UUID bankId);

    Account findById(UUID id);

    List<Account> findByBankId(UUID id);

    List<Transaction> findByAccountId(UUID id);

}
