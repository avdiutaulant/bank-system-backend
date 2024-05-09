package com.taulantavdiu.banksystem.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Fee {

    @NotNull
    @PositiveOrZero
    private Double flatFee;

    @NotNull
    @PositiveOrZero
    private Double percentFee;
}
