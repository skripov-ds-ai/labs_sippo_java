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
        fail();
    }
}
