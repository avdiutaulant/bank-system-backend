package com.taulantavdiu.banksystem.repositories;

import com.taulantavdiu.banksystem.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID>{

    List<Account> findByBankId(UUID id);


}
