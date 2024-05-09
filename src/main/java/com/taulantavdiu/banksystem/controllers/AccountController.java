package com.taulantavdiu.banksystem.controllers;

import com.taulantavdiu.banksystem.dtos.AccountResponseDto;
import com.taulantavdiu.banksystem.dtos.OwnTransactionDto;
import com.taulantavdiu.banksystem.dtos.TransactionResponseDto;
import com.taulantavdiu.banksystem.mappers.AccountMapper;
import com.taulantavdiu.banksystem.mappers.TransactionMapper;
import com.taulantavdiu.banksystem.services.AccountService;
import com.taulantavdiu.banksystem.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    private final TransactionMapper transactionMapper;

    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> findById(@PathVariable UUID id) {
        var account = accountService.findById(id);

        var accountResponseDto = accountMapper.toDto(account);

        return ResponseEntity.ok(accountResponseDto);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<AccountResponseDto> withdraw(@PathVariable UUID id, @RequestBody @Valid OwnTransactionDto dto) {
        var account = transactionService.withdraw(transactionMapper.toEntity(dto), id);

        var accountResponseDto = accountMapper.toDto(account);

        return ResponseEntity.ok(accountResponseDto);
    }

    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountResponseDto> deposit(@PathVariable UUID id, @RequestBody @Valid OwnTransactionDto dto) {
        var account = transactionService.deposit(transactionMapper.toEntity(dto), id);

        var accountResponseDto = accountMapper.toDto(account);

        return ResponseEntity.ok(accountResponseDto);
    }

    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionResponseDto>> getTransactions(@PathVariable UUID id) {
        var transactions = accountService.findByAccountId(id);

        var transactionResponseDto = transactions.stream().map(transactionMapper::toDto).collect(Collectors.toList());

        return ResponseEntity.ok(transactionResponseDto);
    }

}
