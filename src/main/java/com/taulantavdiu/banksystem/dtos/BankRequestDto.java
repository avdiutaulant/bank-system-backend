package com.taulantavdiu.banksystem.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Builder
public record BankRequestDto(

        @NotNull
        @Length(min = 2)
        String name,

        @NotNull
        @Min(0)
        BigDecimal flatFee,

        @NotNull
        @Min(0)
        @Max(100)
        BigDecimal percentFee
) {
}
