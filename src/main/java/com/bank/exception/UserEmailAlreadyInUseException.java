package com.bank.exception;

//extend runtimeE to make it unchecked, extend Exception to make in checked
public class UserEmailAlreadyInUseException extends RuntimeException {
    public UserEmailAlreadyInUseException(String message) {
        super(message);
    }
}