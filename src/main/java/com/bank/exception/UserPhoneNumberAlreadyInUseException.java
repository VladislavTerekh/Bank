package com.bank.exception;

public class UserPhoneNumberAlreadyInUseException extends RuntimeException {
    public UserPhoneNumberAlreadyInUseException(String message) {
        super(message);
    }
}
