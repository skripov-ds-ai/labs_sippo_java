package com.examples.skripov.sippo.lesson1.search_extremum.exceptions;

public class FibonacciOverFlowException extends Throwable {
    public FibonacciOverFlowException() {
    }

    public FibonacciOverFlowException(String s) {
        super(s);
    }

    public FibonacciOverFlowException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public FibonacciOverFlowException(Throwable throwable) {
        super(throwable);
    }

    public FibonacciOverFlowException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
