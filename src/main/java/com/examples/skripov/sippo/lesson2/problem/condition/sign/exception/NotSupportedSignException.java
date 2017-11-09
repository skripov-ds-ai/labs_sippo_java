package com.examples.skripov.sippo.lesson2.problem.condition.sign.exception;

public class NotSupportedSignException extends Exception {
    public NotSupportedSignException() {
    }

    public NotSupportedSignException(String message) {
        super(message);
    }

    public NotSupportedSignException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedSignException(Throwable cause) {
        super(cause);
    }

    public NotSupportedSignException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
