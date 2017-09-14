package com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions;

/**
 * Created by 1 on 23.04.2017.
 */
public class OutOfDomainException extends Exception {
    public OutOfDomainException() {
    }

    public OutOfDomainException(String message) {
        super(message);
    }

    public OutOfDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfDomainException(Throwable cause) {
        super(cause);
    }

    public OutOfDomainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
