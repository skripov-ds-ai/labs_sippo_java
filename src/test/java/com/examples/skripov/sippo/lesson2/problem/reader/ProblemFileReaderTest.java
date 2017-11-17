package com.examples.skripov.sippo.lesson2.problem.reader;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ProblemFileReaderTest {

    @Test
    public void testReadProblemFromResources() throws Exception {
        Problem actual = null;


        List<Fraction> coefficients = Arrays.asList(new Fraction(1), new Fraction(2));
        ObjectiveFunction function = new ObjectiveFunction(Extremum.MAX, coefficients);

        Condition condition1 = new Condition(
                ConditionSign.EQUAL,
                Arrays.asList(
                        new Fraction(2),
                        new Fraction(3)),
                new Fraction(1));
        Condition condition2 = new Condition(
                ConditionSign.LESS_OR_EQUAL,
                Arrays.asList(
                        new Fraction(4),
                        new Fraction(5)),
                new Fraction(2));
        Condition condition3 = new Condition(
                ConditionSign.MORE_OR_EQUAL,
                Arrays.asList(
                        new Fraction(0),
                        new Fraction(1)),
                new Fraction(3));

        Problem expected = new Problem(function, Arrays.asList(condition1, condition2, condition3));

        File file = new File("src/test/resources/lesson2/problem/reader/src.txt");

        try (
                ProblemFileReader reader = new ProblemFileReader(file);
                ) {
            actual = reader.readProblem();
        }

        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }
}
