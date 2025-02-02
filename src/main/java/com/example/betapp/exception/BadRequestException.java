package com.example.betapp.exception;

public class BadRequestException extends Exception{

    public BadRequestException() {
        super();
    }

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(Exception e) {
        super(e);
    }

    public BadRequestException(String msg, Exception e) {
        super(msg, e);
    }
}
