package com.examples.skripov.sippo.lesson1.search_extremum;

import com.examples.skripov.sippo.lesson1.helper_classes.Answer;
import com.examples.skripov.sippo.lesson1.helper_classes.Interval;
import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.exceptions.FibonacciOverFlowException;
import com.examples.skripov.sippo.lesson1.search_extremum.fibonacci_numbers.FibonacciConstants;
import com.examples.skripov.sippo.lesson1.search_extremum.fibonacci_numbers.FibonacciNumber;
import com.examples.skripov.sippo.lesson1.search_extremum.function.IFunction;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;

import java.util.ArrayList;
import java.util.List;

import static com.examples.skripov.sippo.lesson1.constants.Constants.*;

// my variant!
public class FibonacciSearchExtremum {

    public static List<Answer> getExtremum(double epsilon, int iterations, boolean minimum, IFunction function) throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException, FibonacciOverFlowException {
        double a = function.getLeft(), b = function.getRight();

        int n = iterations;

        if (n > FibonacciConstants.MAX_N) {
            throw new FibonacciOverFlowException("If n = " + n + " > " + FibonacciConstants.MAX_N + " then we have overflow.");
        }

        ArrayList<Long> fibs = FibonacciNumber.getFibonacciNumbersVector(n + 2);

        double diff = b - a;
        double x1, x2, fx1, fx2;

        List<Answer> answerList = new ArrayList<>();

        x1 = a + diff * fibs.get(fibs.size() - 3) / (fibs.get(fibs.size() - 1)); // F(n-2) / F(n)
        x2 = a + (diff * fibs.get(fibs.size() - 2)) / (fibs.get(fibs.size() - 1)); // F(n-1) / F(n)

        fx1 = function.compute(x1);
        fx2 = function.compute(x2);

        answerList.add(new Answer(new Interval(new Point2D(x1, fx1), new Point2D(x2, fx2)), function.compute(0.0 + x1 + (0.0 + x2 - x1) / 2)));

        for (int iter = 0; iter < iterations; iter++) {
            diff = b - a;

            if (Math.abs(diff) < epsilon) {
                break;
            }

            if (fx1 > fx2 && minimum || fx1 <= fx2 && !minimum) {
                a = x1;
                x1 = x2;
                x2 = b - x1 + a;

                fx1 = fx2;
                fx2 = function.compute(x2);


            } else {
                b = x2;
                x2 = x1;
                x1 = a - x2 + b;

                fx2 = fx1;
                fx1 = function.compute(x1);
            }

            answerList.add(new Answer(new Interval(new Point2D(x1, fx1), new Point2D(x2, fx2)), function.compute(0.0 + x1 + (0.0 + x2 - x1) / 2)));
        }

        /*double x, fx;
        x = (x1 + x2) / 2;
        fx = function.compute(x);*/

        return answerList;
    }

    /*public static List<Answer> getExtremum(double epsilon, int iterations, boolean minimum, IFunction function) throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException, FibonacciOverFlowException {
        double a = 0.0 + function.getLeft(), b = 0.0 + function.getRight();

        int n = iterations, k = 0;

        if (n > FibonacciConstants.MAX_N) {
            throw new FibonacciOverFlowException("If n = " + n + " > " + FibonacciConstants.MAX_N + " then we have overflow.");
        }

        ArrayList<Integer> fibs = FibonacciNumber.getFibonacciNumbersVector(n);

        double diff;
        double x, x1, x2, x3, x4, fx1, fx2, fx3, fx4;

        diff = 0.0 + b - a;
        x1 = 0.0 + a;
        x2 = 0.0 + a + (0.0 + (diff) * fibs.get(fibs.size() - 2) + epsilon * Math.pow(-1.0, n)) / (0.0 + fibs.get(fibs.size() - 1));
        x3 = 0.0 + b;


        fx2 = function.compute(x2);

        System.out.println((0.0 + (diff) * fibs.get(fibs.size() - 2) + epsilon * Math.pow(-1.0, n)) / (0.0 + fibs.get(fibs.size() - 1)));

        List<Answer> logs = new ArrayList<>();

        while (true) {

            x4 = 0.0 + x1 - x2 + x3;

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
            System.out.println("x3 = " + x3);
            System.out.println("x4 = " + x4);

            fx4 = function.compute(x4);

            Point2D left, right;
            left = new Point2D(x1, function.compute(x1));
            right = new Point2D(x3, function.compute(x3));

            Interval interval = new Interval(left, right);
            Answer answer = new Answer(interval, fx2);

            logs.add(answer);

            if (fx4 > fx2 && minimum || fx4 <= fx2 && !minimum) {
                if (x2 < x4 && minimum || x2 >= x4 && !minimum) {
                    x3 = x4;
                } else {
                    x1 = x4;
                }
            } else {
                if (x2 < x4 && minimum || x2 >= x4 && !minimum) {
                    x1 = x2;
                } else {
                    x3 = x2;
                }
                x2 = x4;
                fx2 = fx4;
            }
            k += 1;

            if (k >= iterations) {
                break;
            }
        }

        System.out.println();


        return logs;
    }*/

    /*public static Point2D getExtremum(double epsilon, int iterations, boolean minimum, IFunction function) throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException, FibonacciOverFlowException {
        double a = function.getLeft(), b = function.getRight();

        int n = iterations;

        if (n > FibonacciConstants.MAX_N) {
            throw new FibonacciOverFlowException("If n = " + n + " > " + FibonacciConstants.MAX_N + " then we have overflow.");
        }

        ArrayList<Long> fibs = FibonacciNumber.getFibonacciNumbersVector(n);

        double diff = b - a;
        double x1, x2, fx1, fx2;

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
    }*/

}
