package com.taulantavdiu.banksystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Positive
    private Double amount;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account sender;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Account receiver;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

}
