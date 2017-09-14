package com.examples.skripov.sippo.lesson1.search_extremum;

import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.exceptions.FibonacciOverFlowException;
import com.examples.skripov.sippo.lesson1.search_extremum.fibonacci_numbers.FibonacciConstants;
import com.examples.skripov.sippo.lesson1.search_extremum.fibonacci_numbers.FibonacciNumber;
import com.examples.skripov.sippo.lesson1.search_extremum.function.IFunction;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

import java.util.ArrayList;

import static com.examples.skripov.sippo.lesson1.constants.Constants.*;

// my variant!
public class FibonacciSearchExtremum {
    public static Point2D getExtremum(double epsilon, int iterations, boolean minimum, IFunction function) throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException, FibonacciOverFlowException {
        double a = function.getLeft(), b = function.getRight();

        int n = iterations;

        if (n > FibonacciConstants.MAX_N) {
            throw new FibonacciOverFlowException("If n = " + n + " > " + FibonacciConstants.MAX_N + " then we have overflow.");
        }

        ArrayList<Long> fibs = FibonacciNumber.getFibonacciNumbersVector(n);

        double diff = b - a;
        double x1, x2, x3, fx1, fx2;

        x1 = a + diff * fibs.get(fibs.size() - 3) / (fibs.get(fibs.size() - 1)); // F(n-2) / F(n)
        x2 = a + (diff * fibs.get(fibs.size() - 2)) / (fibs.get(fibs.size() - 1)); // F(n-1) / F(n)

        fx1 = function.compute(x1);
        fx2 = function.compute(x2);


        for (int iter = 0; iter < iterations; iter++) {
            diff = b - a;

            if (Math.abs(diff) < epsilon) {
                break;
            }

            if (fx1 > fx2 && minimum || fx1 <= fx2 && !minimum) {
                a = x1;
                x1 = x2;
                x2 = b - x1 + a;//Math.abs(x1 - a);

                fx1 = fx2;
                fx2 = function.compute(x2);


            } else {
                b = x2;
                x2 = x1;
                x1 = a - x2 + b;//Math.abs(b - x2);

                fx2 = fx1;
                fx1 = function.compute(x1);
            }
        }

        double x, fx;
        x = (x1 + x2) / 2;
        fx = function.compute(x);

        return new Point2D(x, fx);
    }

}
