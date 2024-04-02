package com.Work2151617.demo.Work21517.exception;

public class ArrIntegerIsFullException extends RuntimeException {
    public ArrIntegerIsFullException() {
    }

    public ArrIntegerIsFullException(String message) {
        super(message);
    }

    public ArrIntegerIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrIntegerIsFullException(Throwable cause) {
        super(cause);
    }

    public ArrIntegerIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
