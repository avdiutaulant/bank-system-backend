package com.taulantavdiu.banksystem.mappers;

import com.taulantavdiu.banksystem.common.Convertable;
import com.taulantavdiu.banksystem.dtos.BankRequestDto;
import com.taulantavdiu.banksystem.dtos.BankResponseDto;
import com.taulantavdiu.banksystem.models.Bank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BankMapper extends Convertable<Bank, BankResponseDto>{

    BankMapper MAPPER = Mappers.getMapper(BankMapper.class);

    Bank toEntity(BankRequestDto dto);
}
