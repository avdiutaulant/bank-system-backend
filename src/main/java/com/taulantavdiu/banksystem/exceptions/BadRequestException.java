package com.taulantavdiu.banksystem.exceptions;


public class BadRequestException extends RuntimeException {

        public BadRequestException() {
        }

        public BadRequestException(String message) {
            super(message);
        }

        public BadRequestException(String message, Throwable cause) {
            super(message, cause);
        }
}
