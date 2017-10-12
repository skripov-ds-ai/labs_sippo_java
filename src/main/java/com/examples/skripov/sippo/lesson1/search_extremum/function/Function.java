package com.examples.skripov.sippo.lesson1.search_extremum.function;


import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

import static com.examples.skripov.sippo.lesson1.search_extremum.function.constants.Constants.EPS;

/**
 * Created by 1 on 23.04.2017.
 */
public abstract class Function implements IFunction {
    private double left, right;

    public Function(double left, double right) throws IncorrectDomainException {
        this.left = left;
        this.right = right;
        if (left > right) {
            throw new IncorrectDomainException();
        }
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public void setRight(double right) {
        this.right = right;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }

    public double compute(double x) throws OutOfSegmentException, IncorrectDomainException, ArithmeticException, OutOfDomainException, OutOfSegmentException, IncorrectDomainException {
        return 0;
    }

    public boolean isInSegment(double x) {
        return (Math.abs(left - x) < EPS || left <= x) && (Math.abs(right - x) < EPS || x <= right);
    }

    public boolean isCorrectSegment() {
        return left <= right;
    }
}
