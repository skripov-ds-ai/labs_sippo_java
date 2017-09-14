package com.examples.skripov.sippo.lesson1.exceptions;

public class NotTrueOrFalseException extends Throwable {
    public NotTrueOrFalseException() {
    }

    public NotTrueOrFalseException(String s) {
        super(s);
    }

    public NotTrueOrFalseException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotTrueOrFalseException(Throwable throwable) {
        super(throwable);
    }

    public NotTrueOrFalseException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
