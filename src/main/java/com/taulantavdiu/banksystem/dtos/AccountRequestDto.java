package com.taulantavdiu.banksystem.dtos;

import lombok.Builder;

@Builder
public record AccountRequestDto(
        String firstName,
        String lastName
) {
}
