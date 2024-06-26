package com.taulantavdiu.banksystem.dtos;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record AccountResponseDto(
        UUID id,
        String firstName,
        String lastName,
        BigDecimal balance

) {
}
