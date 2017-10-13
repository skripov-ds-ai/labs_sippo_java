package com.examples.skripov.sippo.lesson1.dataunit.reader;

import com.examples.skripov.sippo.lesson1.dataunit.DataUnit;
import com.examples.skripov.sippo.lesson1.dataunit.writer.DataUnitWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class DataUnitReaderTest {

    private final String fullName = "src/main/resources/test-dataunitreader.txt";
    private final String fullNameForIOExceptionWhileReading = "src" + '/' + "main/resources/test-dataunitreader.txt";

    private DataUnit expectedDataUnit;

    @Before
    public void setUp() {
        DataUnit dataUnit = new DataUnit();
        dataUnit.setIterations(14);
        dataUnit.setEpsilon(1e-6);
        dataUnit.setA(0);
        dataUnit.setB(1);
        dataUnit.setMinimum(true);

        expectedDataUnit = dataUnit;

        try(
                DataUnitWriter writer = new DataUnitWriter(fullName);
        ) {
            writer.writeDataUnit(dataUnit);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadDataUnit() throws IOException, ClassNotFoundException {
        DataUnitReader reader = new DataUnitReader(fullName);

        DataUnit actualDataUnit = reader.getDataUnit();

        reader.close();

        Assert.assertEquals(expectedDataUnit, actualDataUnit);

    }


    /*@Test(expected = IOException.class)
    public void testReadDataUnitWithIOException() throws IOException, ClassNotFoundException {

        String s = "some string";

        System.out.println("11!!!");
        try(
                DataUnitWriter writer = new DataUnitWriter(fullNameForIOExceptionWhileReading);
        ) {
            writer.writeDataUnit(expectedDataUnit);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }

        System.out.println("22!!!");
        try (
                FileWriter writer = new FileWriter(fullNameForIOExceptionWhileReading)
        ) {
            writer.write(s);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }

        System.out.println("3!!!!");
        DataUnitReader reader = new DataUnitReader(fullNameForIOExceptionWhileReading);
        System.out.println("1!");
        reader.getDataUnit();

        Assert.fail();
    }*/

    @Test(expected = FileNotFoundException.class)
    public void testReadDataUnitFileNotFound() throws IOException {
        try(
                DataUnitReader reader = new DataUnitReader("");
        ) {
            Assert.fail();
        }
    }

}
