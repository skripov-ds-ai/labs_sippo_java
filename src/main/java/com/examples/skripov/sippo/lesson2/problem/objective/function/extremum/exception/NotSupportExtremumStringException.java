package com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.exception;

public class NotSupportExtremumStringException extends Exception {
    public NotSupportExtremumStringException() {
    }

    public NotSupportExtremumStringException(String message) {
        super(message);
    }

    public NotSupportExtremumStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportExtremumStringException(Throwable cause) {
        super(cause);
    }

    public NotSupportExtremumStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
