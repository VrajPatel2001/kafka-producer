package com.producer.exception;

public class DuplicateUserException extends Exception {

    public DuplicateUserException(String message) {
        super(message);
    }
}