package com.examples.skripov.sippo;

import com.examples.skripov.sippo.lesson1.SippoLessonOneDemoTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SippoTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SippoTest(String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( SippoLessonOneDemoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue( true );
    }
}
