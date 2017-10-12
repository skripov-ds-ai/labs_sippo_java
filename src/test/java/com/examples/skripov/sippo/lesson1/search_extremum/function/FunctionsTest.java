package com.examples.skripov.sippo.lesson1.search_extremum.function;

import com.examples.skripov.sippo.lesson1.search_extremum.FibonacciSearchExtremumTest;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.IncorrectDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfDomainException;
import com.examples.skripov.sippo.lesson1.search_extremum.function.exceptions.OutOfSegmentException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FunctionsTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FunctionsTest( String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( FunctionsTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }

    @Before
    public void setUp() {

    }
    @org.junit.Test(expected = IncorrectDomainException.class)
    public void testIncorrectDomain() throws IncorrectDomainException, OutOfSegmentException, OutOfDomainException {
        try {
            Function function = new SinFunction(1, -1, 1, 1);
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
