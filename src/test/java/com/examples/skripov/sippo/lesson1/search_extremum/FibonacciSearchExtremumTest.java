package com.examples.skripov.sippo.lesson1.search_extremum;

import com.examples.skripov.sippo.lesson1.point2d.Point2D;
import com.examples.skripov.sippo.lesson1.search_extremum.exceptions.FibonacciOverFlowException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.*;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

import static com.examples.skripov.sippo.lesson1.search_extremum.FibonacciSearchExtremum.*;
import static com.examples.skripov.sippo.lesson1.constants.Constants.*;

public class FibonacciSearchExtremumTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FibonacciSearchExtremumTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( FibonacciSearchExtremumTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }

    @org.junit.Test
    public void testGetExtremumMinimumOfFunction4FirstTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new Function4FirstTest(-100, 100, 0.5, -1, 1);

        double eps = 1e-4;
        int iterations = 80;
        boolean minimum = true;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(0.7391, -0.4005);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

    @org.junit.Test
    public void testGetExtremumMinimumOfSin() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new SinFunction(Math.PI, 2 * Math.PI, 1, 1);

        double eps = 1e-7;
        int iterations = 80;
        boolean minimum = true;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(3 * Math.PI / 2, -1);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

    @org.junit.Test
    public void testGetExtremumMaximumOfSin() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new SinFunction(0, Math.PI, 1, 1);

        double eps = 1e-7;
        int iterations = 80;
        boolean minimum = false;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(Math.PI / 2, 1);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

    @org.junit.Test
    public void testGetExtremumMinimumOfFunction4SecondTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        // (0; 1)
        Function function = new Function4SecondTest(0 + EPS, 1 - EPS, 2, -1, 1);

        double eps = 1e-6;
        int iterations = 30;
        boolean minimum = true;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(0.357404, -1.174138);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

    @org.junit.Test
    public void testGetExtremumMinimumOfFunction4ThirdTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new Function4ThirdTest(0 + EPS, 2 - EPS, 1, -14, 60, -70);

        double eps = 1e-5;
        int iterations = 30;
        boolean minimum = true;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(0.78089, -24.3696);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

    @org.junit.Test
    public void testGetExtremumMinimumOfFunction4FourthTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        // (-4; -3)
        Function function = new Function4FourthTest(-4, -3.4, 3, 1e-5, -2);

        double eps = 1e-3;
        int iterations = 92;
        boolean minimum = true;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(-3.66, 0);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

    @org.junit.Test
    public void testGetExtremumMinimumOfFunction4FifthTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new Function4FifthTest(-3.6, -3.4, 45, 5, 0.05);

        double eps = 1e-5;
        int iterations = 92;
        boolean minimum = true;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(-3.50032, 0);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

    @org.junit.Test
    public void testGetExtremumMaximumOfFunction4FifthTest() throws FibonacciOverFlowException, OutOfSegmentException, OutOfDomainException, IncorrectDomainException {
        Function function = new Function4FifthTest(-3.33, -3.17, 45, 5, 0.05);

        double eps = 1e-3;
        int iterations = 92;
        boolean minimum = false;

        Point2D actual = getExtremum(eps, iterations, minimum, function);
        Point2D expected = new Point2D(-3.22, 0);

        assertEquals(expected.getX(), actual.getX(), eps);
    }

}
