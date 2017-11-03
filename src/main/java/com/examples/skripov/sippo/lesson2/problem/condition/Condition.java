package com.examples.skripov.sippo.lesson2.problem.condition;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;

import java.util.Arrays;
import java.util.List;

public class Condition {
    private ConditionSign sign = ConditionSign.LESS_OR_EQUAL;

    private List<Fraction> coefficients;
    private Fraction freeFactor;

    public Condition(ConditionSign sign, List<Fraction> coefficients, Fraction freeFactor) {
        this.sign = sign;
        this.coefficients = coefficients;
        this.freeFactor = freeFactor;
    }

    public final ConditionSign getSign() {
        return sign;
    }

    public final void setSign(ConditionSign sign) {
        this.sign = sign;
    }

    public final List<Fraction> getCoefficients() {
        return coefficients;
    }

    public final void setCoefficients(List<Fraction> coefficients) {
        this.coefficients = coefficients;
    }

    public final Fraction getFreeFactor() {
        return freeFactor;
    }

    public final void setFreeFactor(Fraction freeFactor) {
        this.freeFactor = freeFactor;
    }

    public final void addVariables(Fraction ... vars) {
        coefficients.addAll(Arrays.asList(vars));
    }
}
