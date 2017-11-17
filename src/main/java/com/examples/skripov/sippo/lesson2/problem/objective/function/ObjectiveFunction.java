package com.examples.skripov.sippo.lesson2.problem.objective.function;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;

import java.util.ArrayList;
import java.util.List;

public class ObjectiveFunction {
    private Extremum extremum = Extremum.MAX;

    //private Fraction freeFactor;
    private ArrayList<Fraction> coefficients;

    public ObjectiveFunction(Extremum extremum, ArrayList<Fraction> coefficients) {
        this.extremum = extremum;
        this.coefficients = coefficients;
    }

    /*public ObjectiveFunction(Extremum extremum, Fraction freeFactor, List<Fraction> coefficients) {
        this.extremum = extremum;
        this.freeFactor = freeFactor;
        this.coefficients = coefficients;
    }*/

    public final Extremum getExtremum() {
        return extremum;
    }

    public final void setExtremum(Extremum extremum) {
        this.extremum = extremum;
    }

    /*public final Fraction getFreeFactor() {
        return freeFactor;
    }

    public final void setFreeFactor(Fraction freeFactor) {
        this.freeFactor = freeFactor;
    }*/

    public final void addZeroCoefficient() {
        coefficients.add(Fraction.ZERO);
    }

    public final void negateCoefficients() {
        for (int i = 0; i < coefficients.size(); i++) {
            coefficients.get(i).negate();
        }
    }

    public final List<Fraction> getCoefficients() {
        return coefficients;
    }

    public final void setCoefficients(ArrayList<Fraction> coefficients) {
        this.coefficients = coefficients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjectiveFunction that = (ObjectiveFunction) o;

        if (extremum != that.extremum) return false;
        return coefficients != null ? coefficients.equals(that.coefficients) : that.coefficients == null;
    }

    @Override
    public int hashCode() {
        int result = extremum != null ? extremum.hashCode() : 0;
        result = 31 * result + (coefficients != null ? coefficients.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ObjectiveFunction{" +
                "extremum=" + extremum +
                ", coefficients=" + coefficients +
                '}';
    }
}
