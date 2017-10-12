package com.examples.skripov.sippo.lesson1.writer;

import com.examples.skripov.sippo.lesson1.dataunit.DataUnit;

import java.io.IOException;

public class DataUnitWriter implements AutoCloseable {
    private FileWriter fileWriter;

    public DataUnitWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void writeDataUnit() throws IOException {
        DataUnit dataUnit = new DataUnit();


    }

    @Override
    public void close() throws Exception {
        fileWriter.close();
    }
}
