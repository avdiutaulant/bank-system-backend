package com.taulantavdiu.banksystem.controllers;

import com.taulantavdiu.banksystem.dtos.TransactionRequestDto;
import com.taulantavdiu.banksystem.dtos.TransactionResponseDto;
import com.taulantavdiu.banksystem.mappers.TransactionMapper;
import com.taulantavdiu.banksystem.models.Transaction;
import com.taulantavdiu.banksystem.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public ResponseEntity<TransactionResponseDto> save(@RequestBody @Valid TransactionRequestDto transactionRequestDto) {

        Transaction transaction = transactionService.addTransaction(transactionMapper.toEntity(transactionRequestDto));

        var transactionResponseDto = transactionMapper.toDto(transaction);

        return ResponseEntity.ok(transactionResponseDto);
    }



}
