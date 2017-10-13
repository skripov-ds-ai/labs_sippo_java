package com.examples.skripov.sippo.lesson1.dataunit.writer;

import com.examples.skripov.sippo.lesson1.dataunit.DataUnit;

import java.io.*;

public class DataUnitWriter implements AutoCloseable {
    private ObjectOutputStream stream;

    public DataUnitWriter(String fullName) throws IOException {
        this(new FileOutputStream(fullName));
    }

    public DataUnitWriter(String name, String path) throws IOException {
        this(path.concat(name));
    }

    public DataUnitWriter(FileOutputStream fos) throws IOException {
        stream = new ObjectOutputStream(fos);
    }

    public DataUnitWriter(ObjectOutputStream stream) {
        this.stream = stream;
    }

    public void writeDataUnit(DataUnit dataUnit) throws IOException {
        dataUnit.writeExternal(stream);
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
