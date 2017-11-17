package com.examples.skripov.sippo.lesson2.problem.condition;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Condition {
    private ConditionSign sign = ConditionSign.LESS_OR_EQUAL;

    private List<Fraction> coefficients;
    private Fraction freeFactor;
    private List<Fraction> artificialCoefficients = new ArrayList<>();

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

    public final void addArtificialCoefficients(Fraction ... artificialCoefficients) {
        this.artificialCoefficients.addAll(Arrays.asList(artificialCoefficients));
    }

    public final long getArtificialVariablesCount() {
        return artificialCoefficients.size();
    }

    public List<Fraction> getArtificialCoefficients() {
        return artificialCoefficients;
    }

    public final List<Fraction> getAllCoefficients() {
        List<Fraction> tmp = new ArrayList<>();
        tmp.add(this.getFreeFactor());
        tmp.addAll(this.getCoefficients());
        tmp.addAll(this.getArtificialCoefficients());
        return tmp;
    }

    public int getMaxIndexOfVariable() {
        return coefficients.size() - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        if (sign != condition.sign) return false;
        if (coefficients != null ? !coefficients.equals(condition.coefficients) : condition.coefficients != null)
            return false;
        return freeFactor != null ? freeFactor.equals(condition.freeFactor) : condition.freeFactor == null;
    }

    @Override
    public int hashCode() {
        int result = sign != null ? sign.hashCode() : 0;
        result = 31 * result + (coefficients != null ? coefficients.hashCode() : 0);
        result = 31 * result + (freeFactor != null ? freeFactor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "sign=" + sign +
                ", coefficients=" + coefficients +
                ", freeFactor=" + freeFactor +
                '}';
    }
}
