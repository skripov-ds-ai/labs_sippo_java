package com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions;

/**
 * Created by 1 on 23.04.2017.
 */
public class OutOfSegmentException extends Exception {
    public OutOfSegmentException() {
    }

    public OutOfSegmentException(String message) {
        super(message);
    }

    public OutOfSegmentException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfSegmentException(Throwable cause) {
        super(cause);
    }

    public OutOfSegmentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
