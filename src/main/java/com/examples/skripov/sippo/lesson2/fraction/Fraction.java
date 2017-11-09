package com.examples.skripov.sippo.lesson2.fraction;

import java.math.BigInteger;

public class Fraction {
    private BigInteger nominator;
    private BigInteger denominator;

    public Fraction(int nominator) {
        this.nominator = BigInteger.valueOf(nominator);
        this.denominator = BigInteger.ONE;
    }

    public Fraction(long nominator) {
        this.nominator = BigInteger.valueOf(nominator);
        this.denominator = BigInteger.ONE;
    }

    public Fraction(BigInteger nominator) {
        this.nominator = nominator;
        this.denominator = BigInteger.ONE;
    }

    public Fraction(int nominator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Illegal value of denominator. denominator = " + denominator);
        }
        this.nominator = BigInteger.valueOf(nominator);
        this.denominator = BigInteger.valueOf(denominator);
    }

    public Fraction(long nominator, long denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("Illegal value of denominator. denominator = " + denominator);
        }
        this.nominator = BigInteger.valueOf(nominator);
        this.denominator = BigInteger.valueOf(denominator);
    }

    public Fraction(BigInteger nominator, BigInteger denominator) {
        if (denominator.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("Illegal value of denominator. denominator = " + denominator);
        }
        this.nominator = nominator;
        this.denominator = denominator;
    }

    public BigInteger getNominator() {
        return nominator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public Fraction negate() {
        return  new Fraction(
                    nominator.negate(),
                    denominator);
    }

    public Fraction reverse() {
        return  new Fraction(
                    new BigInteger(String.valueOf(denominator)),
                    new BigInteger(String.valueOf(nominator)));
    }

    private Fraction reduceFraction(BigInteger nominator, BigInteger denominator) {
        BigInteger gcd = nominator.gcd(denominator);

        nominator = nominator.divide(gcd);
        denominator = denominator.divide(gcd);

        return new Fraction(nominator, denominator);
    }

    public Fraction add(Fraction another) {
        BigInteger a = this.getNominator();
        BigInteger b = this.getDenominator();
        BigInteger c = another.getNominator();
        BigInteger d = another.getDenominator();

        BigInteger nominator = a.multiply(d).add(c.multiply(b));
        BigInteger denominator = b.multiply(d);

        BigInteger gcd = nominator.gcd(denominator);

        nominator = nominator.divide(gcd);
        denominator = denominator.divide(gcd);

        return reduceFraction(nominator, denominator);
    }

    public Fraction sub(Fraction another) {
        return add(another.negate());
    }

    public Fraction mult(Fraction another) {
        BigInteger a = this.getNominator();
        BigInteger b = this.getDenominator();
        BigInteger c = another.getNominator();
        BigInteger d = another.getDenominator();

        BigInteger nominator = a.multiply(c);
        BigInteger denominator = b.multiply(d);

        BigInteger gcd = nominator.gcd(denominator);

        nominator = nominator.divide(gcd);
        denominator = denominator.divide(gcd);

        return reduceFraction(nominator, denominator);
    }

    public Fraction divide(Fraction another) {
        return mult(another.reverse());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (nominator != null ? !nominator.equals(fraction.nominator) : fraction.nominator != null) return false;
        return denominator != null ? denominator.equals(fraction.denominator) : fraction.denominator == null;
    }

    @Override
    public int hashCode() {
        int result = nominator != null ? nominator.hashCode() : 0;
        result = 31 * result + (denominator != null ? denominator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        /*return "Fraction{" +
                "nominator=" + nominator +
                ", denominator=" + denominator +
                '}';*/
        if (denominator.compareTo(BigInteger.ONE) == 0) {
            return String.valueOf(nominator);
        }
        return nominator + " / " + denominator;
    }
}
