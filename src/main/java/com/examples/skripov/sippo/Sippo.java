package com.examples.skripov.sippo;

import com.examples.skripov.sippo.lesson1.dataunit.DataUnit;
import com.examples.skripov.sippo.lesson1.dataunit.reader.DataUnitReader;
import com.examples.skripov.sippo.lesson1.dataunit.writer.DataUnitWriter;

import java.io.IOException;

public class Sippo {
    private static final String fullName = "src/main/resources/input.txt";

    public static void main(String[] args ) {
        DataUnit dataUnit = new DataUnit();
        dataUnit.setIterations(14);
        dataUnit.setEpsilon(1e-6);
        dataUnit.setA(0);
        dataUnit.setB(1);
        dataUnit.setMinimum(true);

        try(
                DataUnitWriter writer = new DataUnitWriter(fullName);
                DataUnitReader reader = new DataUnitReader(fullName);
                ) {
            writer.writeDataUnit(dataUnit);
            writer.close();
            System.out.println(reader.getDataUnit());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
