package com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions;

/**
 * Created by 1 on 23.04.2017.
 */
public class IncorrectDomainException extends Exception {
    public IncorrectDomainException() {
    }

    public IncorrectDomainException(String message) {
        super(message);
    }

    public IncorrectDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectDomainException(Throwable cause) {
        super(cause);
    }

    public IncorrectDomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
