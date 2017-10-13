package com.examples.skripov.sippo.lesson1.search_extremum.function;

import com.examples.skripov.sippo.lesson1.search_extremum.FibonacciSearchExtremumTest;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FunctionsTest {
    @Before
    public void setUp() {

    }

    @Test(expected = IncorrectDomainException.class)
    public void testIncorrectDomain() throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException {
        Function function = new SinFunction(1, -1, 1, 1);
        Assert.fail();
    }

    @Test(expected = OutOfSegmentException.class)
    public void testOutOfSegment() throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException {
        Function function = new SinFunction(-1, 1, 1, 1);
        function.compute(42);

        Assert.fail();
    }

    @Test(expected = OutOfDomainException.class)
    public void testOutOfDomain() throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException {
        Function function = new FractionFunction(-1, 1, 1, 1, 0,0);
        function.compute(0.5);

        Assert.fail();
    }
}
