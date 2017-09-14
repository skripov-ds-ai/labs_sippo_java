package com.examples.skripov.sippo.lesson1.exceptions;

public class NotConsoleOrFileException extends Throwable {
    public NotConsoleOrFileException() {
    }

    public NotConsoleOrFileException(String s) {
        super(s);
    }

    public NotConsoleOrFileException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotConsoleOrFileException(Throwable throwable) {
        super(throwable);
    }

    public NotConsoleOrFileException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
