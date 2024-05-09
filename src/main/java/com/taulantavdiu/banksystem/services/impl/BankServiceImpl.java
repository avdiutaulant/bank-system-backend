package com.taulantavdiu.banksystem.services.impl;

import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.Bank;
import com.taulantavdiu.banksystem.repositories.BankRepository;
import com.taulantavdiu.banksystem.services.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Override
    public Bank save(Bank bank) {
        bank.setTotalFee(BigDecimal.ZERO);
        bank.setTotalTransfer(BigDecimal.ZERO);

        return bankRepository.save(bank);
    }


}
