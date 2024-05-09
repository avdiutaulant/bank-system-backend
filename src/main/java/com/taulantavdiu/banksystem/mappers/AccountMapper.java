package com.taulantavdiu.banksystem.mappers;

import com.taulantavdiu.banksystem.common.Convertable;
import com.taulantavdiu.banksystem.dtos.AccountRequestDto;
import com.taulantavdiu.banksystem.dtos.AccountResponseDto;
import com.taulantavdiu.banksystem.models.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper extends Convertable<Account, AccountResponseDto> {

    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);


    Account toEntity(AccountRequestDto dto);
}
