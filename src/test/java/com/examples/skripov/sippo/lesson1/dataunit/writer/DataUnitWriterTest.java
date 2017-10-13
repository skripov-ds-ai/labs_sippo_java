package com.examples.skripov.sippo.lesson1.dataunit.writer;

import com.examples.skripov.sippo.lesson1.dataunit.DataUnit;
import com.examples.skripov.sippo.lesson1.dataunit.reader.DataUnitReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DataUnitWriterTest {


    private final String fullName = "src/main/resources/test-dataunitwriter.txt";
    private final String path = "src/main/resources/";

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteDataUnit() throws IOException, ClassNotFoundException {
        String name = path.concat("test-write1.txt");

        DataUnitWriter writer = new DataUnitWriter(name);

        writer.writeDataUnit(expectedDataUnit);
        writer.close();

        DataUnitReader reader = new DataUnitReader(name);

        DataUnit actualDataUnit = reader.getDataUnit();
        reader.close();

        Assert.assertEquals(expectedDataUnit, actualDataUnit);
    }

    @Test(expected = FileNotFoundException.class)
    public void testWriteDataUnitFileNotFound() throws IOException {
        DataUnitWriter writer = new DataUnitWriter("");
        Assert.fail();
    }

}
