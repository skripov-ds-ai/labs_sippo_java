package com.examples.skripov.sippo.lesson2.problem.condition;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.variable.VariableType;

import java.util.ArrayList;

public class Condition {
    private ConditionSign sign = ConditionSign.LESS_OR_EQUAL;

    private ArrayList<VariableType> types;
    private ArrayList<Fraction> coefficients;
    private Fraction freeFactor;

    public Condition(ConditionSign sign, ArrayList<Fraction> coefficients, Fraction freeFactor) {
        this.sign = sign;
        this.coefficients = coefficients;
        this.freeFactor = freeFactor;
        types = new ArrayList<>();
        for (int i = 0; i < coefficients.size(); i++) {
            types.add(VariableType.NORM);
        }
    }

    public final ConditionSign getSign() {
        return sign;
    }

    public final void setSign(ConditionSign sign) {
        this.sign = sign;
    }

    public final ArrayList<Fraction> getCoefficients() {
        return coefficients;
    }

    public final void setCoefficients(ArrayList<Fraction> coefficients) {
        this.coefficients = coefficients;
    }

    public ArrayList<VariableType> getTypes() {
        return types;
    }

    public final ArrayList<Fraction> allCoefficients() {
        ArrayList<Fraction> allCoefs = new ArrayList<>();
        allCoefs.add(freeFactor);
        allCoefs.addAll(coefficients);
        return allCoefs;
    }

    public final void addCoefficient(Fraction a, VariableType type) {
        coefficients.add(a);
        types.add(type);
    }

    public final void negateCoefficients() {
        freeFactor.negate();
        for (int i = 0; i < coefficients.size(); i++) {
            coefficients.get(i).negate();
        }
    }

    public final void negateVarCoefficients() {
        for (int i = 0; i < coefficients.size(); i++) {
            coefficients.get(i).negate();
        }
    }

    public final Fraction getFreeFactor() {
        return freeFactor;
    }

    public final void setFreeFactor(Fraction freeFactor) {
        this.freeFactor = freeFactor;
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
                ", types=" + types +
                ", coefficients=" + coefficients +
                ", freeFactor=" + freeFactor +
                '}';
    }
}
