package com.examples.skripov.sippo.lesson2.fraction;

import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

    @Test
    public void testAdd() {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 2);

        Fraction expected = new Fraction(2, 1);

        Fraction c = a.add(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testSub() {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 2);

        Fraction expected = new Fraction(-1, 1);

        Fraction c = a.sub(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testMult() {
        Fraction a = new Fraction(1, 248);
        Fraction b = new Fraction(248);

        Fraction expected = new Fraction(1);

        Fraction c = a.mult(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testDivide() {
        Fraction a = new Fraction(1, 248);
        Fraction b = new Fraction(248);

        Fraction expected = new Fraction(1, 248 * 248);

        Fraction c = a.divide(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testNegate() {
        Fraction a = new Fraction(1, 3);

        Fraction actual = a.negate();

        Fraction expected = new Fraction(-1, 3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverse() {
        Fraction a = new Fraction(1, 3);

        Fraction actual = a.reverse();

        Fraction expected = new Fraction(3, 1);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZeroDenominator() {
        Fraction a = new Fraction(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDenominator() {
        Fraction a = new Fraction(-1, -42);
    }
}
