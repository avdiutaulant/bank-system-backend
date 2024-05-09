package com.taulantavdiu.banksystem.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BusinessErrorCodes {

    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "Bad request"),
    NOT_FOUND(404, HttpStatus.NOT_FOUND, "Resource not found"),

    ;

    private final int code;

    private final String description;

    private final HttpStatus httpStatus;


    BusinessErrorCodes(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
