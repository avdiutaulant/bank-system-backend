package com.taulantavdiu.banksystem.services;

import com.taulantavdiu.banksystem.models.Account;

import java.util.UUID;

public interface AccountService {

    Account save(Account account, UUID bankId);

    Account findById(UUID id);

}
