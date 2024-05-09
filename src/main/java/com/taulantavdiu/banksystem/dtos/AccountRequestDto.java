package com.taulantavdiu.banksystem.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

@Builder
public record AccountRequestDto(
        @NotNull
        @Length(min = 2)
        String firstName,

        @NotNull
        @Length(min = 2)
        String lastName
) {
}
