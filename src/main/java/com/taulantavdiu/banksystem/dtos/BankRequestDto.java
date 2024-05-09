package com.taulantavdiu.banksystem.dtos;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
public record BankRequestDto(
        String name,
        BigDecimal flatFee,
        BigDecimal percentFee
) {
}
