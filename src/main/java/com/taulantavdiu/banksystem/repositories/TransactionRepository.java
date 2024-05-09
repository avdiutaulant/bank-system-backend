package com.taulantavdiu.banksystem.repositories;

import com.taulantavdiu.banksystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
