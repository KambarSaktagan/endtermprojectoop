package com.example.endtermoop.exception;

public class DatabaseOperationException extends RuntimeException {
    public DatabaseOperationException(String msg) { super(msg); }
}