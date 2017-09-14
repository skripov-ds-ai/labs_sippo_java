package com.examples.skripov.sippo.lesson1.search_extremum;

import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.function.IFunction;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

public class QuadraticInterpolationSearchExtremum {
    // todo
    // 3 different xs
    public static Point2D getExtremum(double epsilon, int iterations, boolean minimum, IFunction function) throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException {
        double a = function.getLeft(), b = function.getRight();




        return null;
    }
}
