package com.taulantavdiu.banksystem.controllers;

import com.taulantavdiu.banksystem.dtos.AccountResponseDto;
import com.taulantavdiu.banksystem.mappers.AccountMapper;
import com.taulantavdiu.banksystem.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    public ResponseEntity<AccountResponseDto> findById(UUID id) {
        var account = accountService.findById(id);

        var accountResponseDto = accountMapper.toDto(account);

        return ResponseEntity.ok(accountResponseDto);
    }

}
