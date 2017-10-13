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

        //System.out.println(File.pathSeparatorChar);

        String s = "some string";

        try(
                DataUnitWriter writer = new DataUnitWriter(fullName);
        ) {
            writer.writeDataUnit(dataUnit);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(
                DataUnitWriter writer = new DataUnitWriter(fullNameForIOExceptionWhileReading);
        ) {
            writer.writeDataUnit(dataUnit);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileWriter writer = new FileWriter(fullNameForIOExceptionWhileReading)
        ) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void testReadDataUnitWithIOException() throws IOException, ClassNotFoundException {
        try (
                DataUnitReader reader = new DataUnitReader(fullNameForIOExceptionWhileReading);
        ) {

            reader.getDataUnit();

            Assert.fail();
        }
    }

    @Test
    public void testReadDataUnit() throws IOException, ClassNotFoundException {
        DataUnit actualDataUnit = null;

        try(
                DataUnitReader reader = new DataUnitReader(fullName);
        ) {

            actualDataUnit = reader.getDataUnit();

        }
        Assert.assertEquals(expectedDataUnit, actualDataUnit);

    }

    @Test(expected = FileNotFoundException.class)
    public void testReadDataUnitFileNotFound() throws IOException {
        try(
                DataUnitReader reader = new DataUnitReader("");
        ) {
            Assert.fail();
        }
    }

}
