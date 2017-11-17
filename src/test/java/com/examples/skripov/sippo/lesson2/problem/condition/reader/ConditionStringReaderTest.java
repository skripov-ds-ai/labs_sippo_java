package com.examples.skripov.sippo.lesson2.problem.condition.reader;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.exception.NotSupportedSignException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ConditionStringReaderTest {

    @Test
    public void testGetConditionEqual() throws IOException, NotSupportedSignException {
        String src = "2 3 = 1";

        Condition actual = null;
        Condition expected = new Condition(
                ConditionSign.EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(2),
                        new Fraction(3))),
                new Fraction(1));

        {
        //try (
                ConditionStringReader reader = new ConditionStringReader(src);
        //        ) {
            actual = reader.readCondition();
        //} catch (Exception e) {
        //    e.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetConditionLessOrEqual() throws IOException, NotSupportedSignException {
        String src = "4 5 <= 2";

        Condition actual = null;
        Condition expected = new Condition(
                ConditionSign.LESS_OR_EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(4),
                        new Fraction(5))),
                new Fraction(2));

        {
            //try (
            ConditionStringReader reader = new ConditionStringReader(src);
            //) {
            actual = reader.readCondition();
            //} catch (Exception e) {
            //    e.printStackTrace();
            //}
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetConditionMoreOrEqual() throws IOException, NotSupportedSignException {
        String src = "0  \t 1 >= 3";

        Condition actual = null;
        Condition expected = new Condition(
                ConditionSign.MORE_OR_EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(0),
                        new Fraction(1))),
                new Fraction(3));
        {
        //try (
                ConditionStringReader reader = new ConditionStringReader(src);
        //) {
            actual = reader.readCondition();
        //} catch (Exception e) {
        //    e.printStackTrace();
        }

        Assert.assertEquals(expected, actual);
    }
}
