package com.Work2151617.demo.Work21517.exception;

public class ArrStringIsFullException extends RuntimeException {
    public ArrStringIsFullException() {
    }

    public ArrStringIsFullException(String message) {
        super(message);
    }

    public ArrStringIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrStringIsFullException(Throwable cause) {
        super(cause);
    }

    public ArrStringIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
