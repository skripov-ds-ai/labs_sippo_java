package com.examples.skripov.sippo.lesson1.reader;

import com.examples.skripov.sippo.lesson1.dataunit.DataUnit;

import java.io.IOException;

public class DataUnitReader implements AutoCloseable {
    private FileReader fileReader;

    public DataUnitReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public DataUnit getDataUnit() throws IOException {
        DataUnit dataUnit = new DataUnit();

        dataUnit.setMinimum(fileReader.readBoolean());
        dataUnit.setA(fileReader.readDouble());
        dataUnit.setB(fileReader.readDouble());
        dataUnit.setEpsilon(fileReader.readDouble());
        dataUnit.setIterations(fileReader.readInt());

        return dataUnit;
    }

    @Override
    public void close() throws Exception {
        fileReader.close();
    }
}
