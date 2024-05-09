package com.taulantavdiu.banksystem.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record BankResponseDto(
        UUID id,
        String name,
        BigDecimal totalFee,
        BigDecimal totalTransfer,
        BigDecimal flatFee,
        BigDecimal percentFee){
}
