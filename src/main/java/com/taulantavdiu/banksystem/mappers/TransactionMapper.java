package com.taulantavdiu.banksystem.mappers;

import com.taulantavdiu.banksystem.dtos.OwnTransactionDto;
import com.taulantavdiu.banksystem.dtos.TransactionRequestDto;
import com.taulantavdiu.banksystem.dtos.TransactionResponseDto;
import com.taulantavdiu.banksystem.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "sender.id", target = "senderAccountId")
    @Mapping(source = "receiver.id", target = "receiverAccountId")
    TransactionResponseDto toDto(Transaction transaction);

    @Mapping(source = "senderAccountId", target = "sender.id")
    @Mapping(source = "receiverAccountId", target = "receiver.id")
    Transaction toEntity(TransactionRequestDto dto);

    Transaction toEntity(OwnTransactionDto dto);
}
