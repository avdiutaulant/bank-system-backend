package com.taulantavdiu.banksystem.dtos;

import com.taulantavdiu.banksystem.models.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionRequestDto(
        @NotNull()
        @Min(0)
        BigDecimal amount,

        @NotNull
        UUID senderAccountId,

        @NotNull
        UUID receiverAccountId,

        @NotNull
        TransactionType type,

        String reason
) {
}
