package com.taulantavdiu.banksystem.controllers;

import com.taulantavdiu.banksystem.dtos.AccountRequestDto;
import com.taulantavdiu.banksystem.dtos.AccountResponseDto;
import com.taulantavdiu.banksystem.dtos.BankRequestDto;
import com.taulantavdiu.banksystem.dtos.BankResponseDto;
import com.taulantavdiu.banksystem.mappers.AccountMapper;
import com.taulantavdiu.banksystem.mappers.BankMapper;
import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.Bank;
import com.taulantavdiu.banksystem.services.AccountService;
import com.taulantavdiu.banksystem.services.BankService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;
    private final BankMapper bankMapper;
    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<BankResponseDto> save(@RequestBody @Valid BankRequestDto bankRequestDto) {

        Bank saveBank = bankService.save(bankMapper.toEntity(bankRequestDto));

        var bankResponseDto = bankMapper.toDto(saveBank);

        return ResponseEntity.ok(bankResponseDto);
    }

    @PostMapping("{bankId}/accounts")
    public ResponseEntity<AccountResponseDto> save(@RequestBody @Valid AccountRequestDto dto, @PathVariable UUID bankId) {

        var saveAccount = accountService.save(accountMapper.toEntity(dto), bankId);

        var accountResponseDto = accountMapper.toDto(saveAccount);

        return ResponseEntity.ok(accountResponseDto);
    }

    @GetMapping("{bankId}/accounts")
    public ResponseEntity<List<AccountResponseDto>> findByBankId(@PathVariable UUID bankId) {

        var accounts = accountService.findByBankId(bankId);

        var accountResponseDtoList = accounts.stream().map(accountMapper::toDto).collect(Collectors.toList());

        return ResponseEntity.ok(accountResponseDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankResponseDto> findById(@PathVariable UUID id) {
        var bank = bankService.findById(id);

        var bankResponseDto = bankMapper.toDto(bank);

        return ResponseEntity.ok(bankResponseDto);
    }


}
