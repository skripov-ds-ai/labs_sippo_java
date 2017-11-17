package com.examples.skripov.sippo.lesson2.problem.objective.function.reader;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.ExtremumStringHelper;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.exception.NotSupportExtremumStringException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ObjectiveFunctionStringReader /*implements AutoCloseable*/ {
    //private BufferedReader reader;

    private String s;

    public ObjectiveFunctionStringReader(String s) {
        this.s = s;
        //reader = new BufferedReader(new StringReader(s));
    }

    public ObjectiveFunction readObjectiveFunction() throws IOException, NotSupportExtremumStringException {
        String[] strings = s.split("[\\s\t]+");//reader.readLine().split("[\\s]+");

        Extremum extremum = ExtremumStringHelper.getConditionSign(strings[strings.length - 1].toUpperCase());

        ArrayList<Fraction> coefficients = new ArrayList<>();
        for (int i = 0; i < strings.length - 1; i++) {
            coefficients.add(new Fraction(Long.parseLong(strings[i])));
        }

        return new ObjectiveFunction(extremum, coefficients);
    }

    /*@Override
    public void close() throws Exception {
        reader.close();
    }*/
}
