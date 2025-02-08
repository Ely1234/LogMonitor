package org.example.exceptions;

public class CsvWriteException extends Exception {
    public CsvWriteException(String message) {
        super(message);
    }

    public CsvWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}