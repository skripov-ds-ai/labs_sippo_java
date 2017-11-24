package com.examples.skripov.sippo.lesson2.problem.objective.function.reader;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.exception.NotSupportExtremumStringException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectiveStringReaderTest {

    @Test
    public void testGetObjectiveFunctionMaxUpperCase() throws IOException, NotSupportExtremumStringException {
        String src = "0 1 2 MAX";

        ArrayList<Fraction> coefficients = new ArrayList<>(Arrays.asList(new Fraction(0), new Fraction(1), new Fraction(2)));

        ObjectiveFunction actual = null;
        ObjectiveFunction expected = new ObjectiveFunction(Extremum.MAX, coefficients);

        {
        //try (
                ObjectiveFunctionStringReader reader = new ObjectiveFunctionStringReader(src);
        //        ) {
            actual = reader.readObjectiveFunction();
        //} catch (Exception e) {
        //    e.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetObjectiveFunctionMaxLowerCase() throws IOException, NotSupportExtremumStringException {
        String src = "0 1 2     max";

        ArrayList<Fraction> coefficients = new ArrayList<>(Arrays.asList(new Fraction(0), new Fraction(1), new Fraction(2)));

        ObjectiveFunction actual = null;
        ObjectiveFunction expected = new ObjectiveFunction(Extremum.MAX, coefficients);

        {
        //try (
                ObjectiveFunctionStringReader reader = new ObjectiveFunctionStringReader(src);
        //) {
            actual = reader.readObjectiveFunction();
        //} catch (Exception e) {
        //    e.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetObjectiveFunctionMinLowerUpperCase() throws IOException, NotSupportExtremumStringException {
        String src = "0 1   2    mIN";

        ArrayList<Fraction> coefficients = new ArrayList<>(Arrays.asList(new Fraction(0), new Fraction(1), new Fraction(2)));

        ObjectiveFunction actual = null;
        ObjectiveFunction expected = new ObjectiveFunction(Extremum.MIN, coefficients);

        {
        //try (
                ObjectiveFunctionStringReader reader = new ObjectiveFunctionStringReader(src);
        //) {
            actual = reader.readObjectiveFunction();
        //} catch (Exception e) {
        //    e.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }
}

