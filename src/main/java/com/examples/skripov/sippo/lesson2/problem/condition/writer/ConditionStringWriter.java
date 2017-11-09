package com.examples.skripov.sippo.lesson2.problem.condition.writer;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;

import java.io.StringWriter;

public class ConditionStringWriter implements AutoCloseable {
    private StringWriter writer;

    public ConditionStringWriter() {
        writer = new StringWriter();
    }

    public void write(Condition condition) {
        for (Fraction fraction : condition.getCoefficients()) {
            writer.write(fraction.toString());
        }
        writer.write(condition.getSign().toString());
        writer.write(condition.getFreeFactor().toString());
        writer.flush();
    }

    @Override
    public void close() throws Exception {
        writer.close();
    }
}
