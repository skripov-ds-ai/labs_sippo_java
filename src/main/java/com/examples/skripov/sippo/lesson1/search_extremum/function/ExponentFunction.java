package com.examples.skripov.sippo.lesson1.search_extremum.function;

import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

/**
 * Created by 1 on 23.04.2017.
 */
public class ExponentFunction extends Function implements IFunction {
    private double A, B;

    public ExponentFunction(double left, double right, double a, double b) throws IncorrectDomainException {
        super(left, right);
        A = a;
        B = b;
    }

    public double getA() {
        return A;
    }

    public void setA(double a) {
        A = a;
    }

    public double getB() {
        return B;
    }

    public void setB(double b) {
        B = b;
    }

    @Override
    public double compute(double x) throws OutOfSegmentException, IncorrectDomainException, ArithmeticException {
        if (!isCorrectSegment()) {
            throw new IncorrectDomainException("Incorrect domain: [a; b] = "
                    + "[" + super.getLeft() + "; " + super.getRight() + "]");
        }
        if (!isInSegment(x)) {
            throw new OutOfSegmentException("x = " + x
                    + " is out of domain: [a; b] = " + "[" + super.getLeft()
                    + "; " + super.getRight() + "]");
        }
        {
            return A * Math.exp(x) + B;
        }
    }
}
