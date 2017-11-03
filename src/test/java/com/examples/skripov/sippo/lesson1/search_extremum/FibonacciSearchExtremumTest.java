package com.examples.skripov.sippo.lesson1.search_extremum;

import com.examples.skripov.sippo.lesson1.helper_classes.Answer;
import com.examples.skripov.sippo.lesson1.helper_classes.Interval;
import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.exceptions.FibonacciOverFlowException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.*;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.examples.skripov.sippo.lesson1.search_extremum.FibonacciSearchExtremum.*;
import static com.examples.skripov.sippo.lesson1.constants.Constants.*;
import static org.junit.Assert.assertEquals;

public class FibonacciSearchExtremumTest {
    @Test
    public void testGetExtremumMinimumOfFunction4FirstTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new Function4SecondTest(0, 1, 2, -1, 1);

        double eps = 1e-6;
        double epsilonForCmp = 1e-6;
        int iterations = 14;
        boolean minimum = true;

        List<Answer> actual = getExtremum(eps, iterations, minimum, function);
        //System.out.println(actual);
        double actualFStar = actual.get(actual.size() - 1).getfStar();
        Point2D expected = new Point2D(0.757403, -1.174138);

        assertEquals(expected.getY(), actualFStar, epsilonForCmp);
    }

    @Test
    public void testGetExtremumMinimumOfSin() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new SinFunction(Math.PI, 2 * Math.PI, 1, 1);

        double eps = 1e-7;
        int iterations = 46;
        boolean minimum = true;


        List<Answer> actual = getExtremum(eps, iterations, minimum, function);

        //System.out.println(actual);
        double actualFStar = actual.get(actual.size() - 1).getfStar();
        Point2D expected = new Point2D(3 * Math.PI / 2, -1);

        assertEquals(expected.getY(), actualFStar, eps);
    }

    // todo
    @Test
    public void testGetExtremumMaximumOfSin() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new SinFunction(0, Math.PI, 1, 1);

        double eps = 1e-7;
        int iterations = 30;
        boolean minimum = false;

        List<Answer> actual = getExtremum(eps, iterations, minimum, function);

        //System.out.println(actual);

        double actualFStar = actual.get(actual.size() - 1).getfStar();
        Point2D expected = new Point2D(Math.PI / 2, 1);

        assertEquals(expected.getY(), actualFStar, eps);
    }

    @Test
    public void testGetExtremumMinimumOfFunction4ThirdTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new Function4ThirdTest(0, 2, 1, -14, 60, -70);

        double eps = 0;
        double epsilonForCmp = 1e-4;
        int iterations = 20;
        boolean minimum = true;

        List<Answer> actual = getExtremum(eps, iterations, minimum, function);
        double expectedFStar = -24.3696;
        double actualFStar = actual.get(actual.size() - 1).getfStar();
        //Point2D expected = new Point2D((0.780804 + 0.7809753) / 2, -24.3696);

        //System.out.println(actual);
        assertEquals(expectedFStar, actualFStar, epsilonForCmp);
    }

    @Test
    public void testGetExtremumMinimumOfTrinomialFunction() throws IncorrectDomainException, FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException {
        Function function = new TrinomialFunction(-3, 5, 1.0, 3.0, 0.0);

        double eps = 0;
        double epsilonForCmp = 1e-3;
        int iterations = 20;
        boolean minimum = true;

        List<Answer> actual = getExtremum(eps, iterations, minimum, function);
        double expectedFStar = -2.249;
        double actualFStar = actual.get(actual.size() - 1).getfStar();
        //Point2D expected = new Point2D((0.780804 + 0.7809753) / 2, -24.3696);

        //System.out.println(actual);
        assertEquals(expectedFStar, actualFStar, epsilonForCmp);
    }

}
