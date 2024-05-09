package com.taulantavdiu.banksystem.repositories;

import com.taulantavdiu.banksystem.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankRepository extends JpaRepository<Bank, UUID> {

}
