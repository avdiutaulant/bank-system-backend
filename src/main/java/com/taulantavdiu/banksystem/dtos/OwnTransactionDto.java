package com.taulantavdiu.banksystem.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OwnTransactionDto(@NotNull @Min(0) BigDecimal amount) {
}
