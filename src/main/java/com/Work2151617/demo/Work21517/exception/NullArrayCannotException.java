package com.Work2151617.demo.Work21517.exception;

public class NullArrayCannotException extends RuntimeException {
    public NullArrayCannotException() {
    }

    public NullArrayCannotException(String message) {
        super(message);
    }

    public NullArrayCannotException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullArrayCannotException(Throwable cause) {
        super(cause);
    }

    public NullArrayCannotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
