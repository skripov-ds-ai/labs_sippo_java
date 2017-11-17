package com.examples.skripov.sippo.lesson2.fraction;

import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

    @Test
    public void testAddition() {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 2);

        Fraction expected = new Fraction(2, 1);

        Fraction c = a.addition(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testSubtraction() {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 2);

        Fraction expected = new Fraction(-1, 1);

        Fraction c = a.subtraction(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testMultiplication() {
        Fraction a = new Fraction(1, 248);
        Fraction b = new Fraction(248);

        Fraction expected = new Fraction(1);

        Fraction c = a.multiplication(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testDivision() {
        Fraction a = new Fraction(1, 248);
        Fraction b = new Fraction(248);

        Fraction expected = new Fraction(1, 248 * 248);

        Fraction c = a.division(b);

        Assert.assertEquals(expected, c);
    }

    @Test
    public void testNegating() {
        Fraction a = new Fraction(1, 3);

        Fraction actual = a.negating();

        Fraction expected = new Fraction(-1, 3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReversing() {
        Fraction a = new Fraction(1, 3);

        Fraction actual = a.reversing();

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

    @Test
    public void testAdd() {
        Fraction actual = new Fraction(1, 2);
        actual.add(new Fraction(1));

        Fraction expected = new Fraction(3, 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSub() {
        Fraction actual = new Fraction(1, 2);
        actual.sub(new Fraction(1));

        Fraction expected = new Fraction(-1, 2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMult() {
        Fraction actual = new Fraction(1, 2);
        actual.mult(new Fraction(-4));

        Fraction expected = new Fraction(-2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDiv() {
        Fraction actual = new Fraction(1, 2);
        actual.div(new Fraction(3, 2));

        Fraction expected = new Fraction(1,3);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNegate() {
        Fraction actual = new Fraction(1, 2);
        actual.negate();

        Fraction expected = new Fraction(-1,2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverse() {
        Fraction actual = new Fraction(1, 2);
        actual.reverse();

        Fraction expected = new Fraction(2);

        Assert.assertEquals(expected, actual);
    }
}
