package com.examples.skripov.sippo.lesson2.problem.objective.function;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;

import java.util.List;

public class ObjectiveFunction {
    private Extremum extremum = Extremum.MAX;

    //private Fraction freeFactor;
    private List<Fraction> coefficients;

    public ObjectiveFunction(Extremum extremum, List<Fraction> coefficients) {
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

    public final List<Fraction> getCoefficients() {
        return coefficients;
    }

    public final void setCoefficients(List<Fraction> coefficients) {
        this.coefficients = coefficients;
    }
}
