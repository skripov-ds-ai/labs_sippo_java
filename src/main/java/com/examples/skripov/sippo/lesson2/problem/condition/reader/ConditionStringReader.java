package com.examples.skripov.sippo.lesson2.problem.condition.reader;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.SignStringHelper;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.exception.NotSupportedSignException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ConditionStringReader /*implements AutoCloseable*/ {
    //private BufferedReader reader;

    private String s;

    public ConditionStringReader(String s) {
        this.s = s;
        //reader = new BufferedReader(new StringReader(s));
    }

    public Condition readCondition() throws IOException, NotSupportedSignException {
        String[] strings = s.split("[\\s\t]+");//reader.readLine().split("[\\s\r\t]+");

        /*System.out.println("***");
        for (String s: strings) {
            System.out.println(s);
        }
        System.out.println("###");*/

        ConditionSign sign = SignStringHelper.getConditionSign(strings[strings.length - 2]);

        Fraction freeFactor = new Fraction(Long.parseLong(strings[strings.length - 1]));

        List<Fraction> coefficients = new ArrayList<>();
        for (int i = 0; i < strings.length - 2; i++) {
            coefficients.add(new Fraction(Long.parseLong(strings[i])));
        }

        return new Condition(sign, coefficients, freeFactor);
    }

    /*@Override
    public void close() throws Exception {
        reader.close();
    }*/
}
