package com.examples.skripov.sippo.lesson1.search_extremum.function;

import com.examples.skripov.sippo.lesson1.search_extremum.function.constants.Constants;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

public class Function4FirstTest extends Function implements IFunction {
    private double a, b, c;

    public Function4FirstTest(double left, double right, double a, double b, double c) {
        super(left, right);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    // a = 1/2; b = -1; c = 1; for test!
    // minimum:
    @Override
    public double compute(double x) throws OutOfSegmentException, IncorrectDomainException, ArithmeticException, OutOfDomainException, OutOfSegmentException, IncorrectDomainException {
        if (!isCorrectSegment()) {
            throw new IncorrectDomainException("Incorrect domain: [a; b] = "
                    + "[" + super.getLeft() + "; " + super.getRight() + "]");
        }
        if (!isInSegment(x)) {
            throw new OutOfSegmentException("x = " + x
                    + " is out of segment: [a; b] = " + "[" + super.getLeft()
                    + "; " + super.getRight() + "]");
        }
        {
            return a * x * x + b * Math.sin(c * x);
        }
    }
}
