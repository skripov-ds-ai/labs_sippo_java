package com.examples.skripov.sippo.lesson1.search_extremum;

import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.function.IFunction;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

import java.util.Random;

public class DichotomySearchExtremum {
    private static Random random = new Random(42);

    public static void setSetSeed(int seed) {
        random.setSeed(seed);
    }

    public static Point2D getExtremum(double epsilon, int iterations, boolean minimum, IFunction function) throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException {
        double a = function.getLeft(), b = function.getRight();
        double alpha = random.nextDouble() * (b - a) / 2;

        for (int iter = 0; iter < iterations; iter++) {
            double mid = b - a;

            if (Math.abs(mid) <= 2 * epsilon) {
                break;
            }

            double x1, x2;
            mid /= 2;
            x1 = mid - alpha;
            x2 = mid + alpha;

            double fx1, fx2;
            fx1 = function.compute(x1);
            fx2 = function.compute(x2);

            if (fx1 > fx2 && minimum || fx1 <= fx2 && !minimum) {
                a = x1;
            } else {
                b = x2;
            }
        }

        double x = (b - a) / 2, fx = function.compute(x);

        return new Point2D(x, fx);
    }
}
