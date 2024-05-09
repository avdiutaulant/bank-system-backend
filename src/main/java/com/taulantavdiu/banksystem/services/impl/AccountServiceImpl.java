package com.taulantavdiu.banksystem.services.impl;

import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.repositories.AccountRepository;
import com.taulantavdiu.banksystem.services.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;


    @Override
    public Account save(Account account, UUID bankId) {
         account.setId(bankId);
         return accountRepository.save(account);
    }

    @Override
    public Account findById(UUID id) {
        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account with id " + id + " not found"));
    }
}
