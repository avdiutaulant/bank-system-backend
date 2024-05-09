package com.taulantavdiu.banksystem.common;

public interface Convertable <Entity, Dto> {

     Entity toEntity(Dto dto);

     Dto toDto(Entity entity);
}
