package com.taulantavdiu.banksystem.controllers;

import com.taulantavdiu.banksystem.dtos.AccountResponseDto;
import com.taulantavdiu.banksystem.mappers.AccountMapper;
import com.taulantavdiu.banksystem.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> findById(@PathVariable UUID id) {
        var account = accountService.findById(id);

        var accountResponseDto = accountMapper.toDto(account);

        return ResponseEntity.ok(accountResponseDto);
    }

}
