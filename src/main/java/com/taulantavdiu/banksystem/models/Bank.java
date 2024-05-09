package com.taulantavdiu.banksystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private Double totalFee;

    private Double totalTransfer;

    @Embedded
    private Fee transactionFee;

    @OneToMany(mappedBy = "bank")
    private List<Account> accounts;



}
