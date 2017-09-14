package com.examples.skripov.sippo.lesson1.search_extremum;

import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.function.IFunction;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

import static com.examples.skripov.sippo.lesson1.search_extremum.function.constants.Constants.PHI;

public class GoldenSectionSearchExtremum {
    public static Point2D getExtremum(double epsilon, int iterations, boolean minimum, IFunction function) throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException {
        double a = function.getLeft(), b = function.getRight();

        for (int iter = 0; iter < iterations; iter++) {
            double difDivPhi = b - a;

            if (Math.abs(difDivPhi) <= 2 * epsilon) {
                break;
            }

            double x1, x2;
            difDivPhi /= PHI;
            x1 = b - difDivPhi;
            x2 = a + difDivPhi;

            double fx1, fx2;
            fx1 = function.compute(x1);
            fx2 = function.compute(x2);

            if (fx1 > fx2 && minimum || fx1 <= fx2 && !minimum) {
                a = x1;
            } else {
                b = x2;
            }
        }

        double x, y;
        x = (a + b) / 2;
        y = function.compute(x);

        return new Point2D(x, y);
    }
}
