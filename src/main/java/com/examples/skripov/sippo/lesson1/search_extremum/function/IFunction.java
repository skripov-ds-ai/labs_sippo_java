package com.examples.skripov.sippo.lesson1.search_extremum.function;

import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

/**
 * Created by 1 on 23.04.2017.
 */
public interface IFunction {
    void setLeft(double left);
    void setRight(double right);
    //void setX(double x);
    double getLeft();
    double getRight();
    //double getX();
    double compute(double x) throws OutOfSegmentException, IncorrectDomainException, ArithmeticException, OutOfDomainException, OutOfDomainException;
    boolean isInSegment(double x);
    boolean isCorrectSegment();
}
