package com.taulantavdiu.banksystem.dtos;

import com.taulantavdiu.banksystem.models.Account;
import com.taulantavdiu.banksystem.models.TransactionType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionResponseDto(
        UUID id,
        BigDecimal amount,
        UUID senderAccountId,
        UUID receiverAccountId,
        TransactionType type,
        String reason
) {
}
