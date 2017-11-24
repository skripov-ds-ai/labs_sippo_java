package com.examples.skripov.sippo.lesson2.fraction;

import static java.lang.Math.abs;

public class Fraction implements Comparable<Fraction> {

    private long nominator;
    private long denominator;

    public Fraction(int nominator) {
        this((long) nominator);
    }

    public Fraction(long nominator) {
        this(nominator, 1);
    }

    public Fraction(int nominator, int denominator) {
        this((long) nominator, (long) denominator);
    }

    public Fraction(long nominator, long denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Illegal value of denominator. denominator = " + denominator);
        }
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public long getNominator() {
        return nominator;
    }

    public long getDenominator() {
        return denominator;
    }

    public void negate() {
        nominator *= -1;
    }

    public void reverse() {
        long tmpDenominator = Math.abs(nominator);
        long tmpNominator =  sign(nominator) * denominator;
        denominator = tmpDenominator;
        nominator = tmpNominator;
    }

    private void reduce() {
        long gcd = gcd(abs(nominator), abs(denominator));

        nominator /= gcd;
        denominator /= gcd;
    }

    public void add(Fraction another) {
        long a = this.getNominator();
        long b = this.getDenominator();
        long c = another.getNominator();
        long d = another.getDenominator();

        nominator = a * d + c * b;
        denominator = b * d;

        reduce();
    }

    public void sub(Fraction another) {
        add(another.negating());
    }

    public void mult(Fraction another) {
        long a = this.getNominator();
        long b = this.getDenominator();
        long c = another.getNominator();
        long d = another.getDenominator();

        nominator = a * c;
        denominator = b * d;

        reduce();
    }

    public void div(Fraction another) {
        mult(another.reversing());
    }




    public Fraction negating() {
        return  new Fraction(
                    -nominator,
                    denominator);
    }

    private long sign(long a) {
        if (a > 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        return -1;
    }

    public Fraction reversing() {
        long tmpDenominator = Math.abs(nominator);
        long tmpNominator =  sign(nominator) * denominator;
        return  new Fraction(
                tmpNominator,
                tmpDenominator
        );
    }

    private Fraction reductionFraction(long nominator, long denominator) {
        long gcd = gcd(abs(nominator), abs(denominator));

        nominator /= gcd;
        denominator /= gcd;

        return new Fraction(nominator, denominator);
    }

    public Fraction addition(Fraction another) {
        long a = this.getNominator();
        long b = this.getDenominator();
        long c = another.getNominator();
        long d = another.getDenominator();

        long nominator = a * d + c * b;
        long denominator = b * d;

        return reductionFraction(nominator, denominator);
    }

    public Fraction subtraction(Fraction another) {
        return addition(another.negating());
    }

    public Fraction multiplication(Fraction another) {
        long a = this.getNominator();
        long b = this.getDenominator();
        long c = another.getNominator();
        long d = another.getDenominator();

        long nominator = a * c;
        long denominator = b * d;

        return reductionFraction(nominator, denominator);
    }

    public Fraction division(Fraction another) {
        return multiplication(another.reversing());
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            a %= b;

            long t = a;
            a = b;
            b = t;
        }
        return a;
    }

    public Fraction identity() {
        return new Fraction(nominator, denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (nominator != fraction.nominator) return false;
        return denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        int result = (int) (nominator ^ (nominator >>> 32));
        result = 31 * result + (int) (denominator ^ (denominator >>> 32));
        return result;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(nominator);
        }
        return nominator + "/" + denominator;
    }

    @Override
    public int compareTo(Fraction o) {
        long a = nominator;
        long b = denominator;
        long c = o.getNominator();
        long d = o.getDenominator();

        long cond = a*d - b*c;

        if (cond < 0) {
            return -1;
        }
        if (cond > 0) {
            return 1;
        }
        return 0;
    }
}
