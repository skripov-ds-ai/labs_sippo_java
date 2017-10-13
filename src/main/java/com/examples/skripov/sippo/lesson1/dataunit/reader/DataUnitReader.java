package com.examples.skripov.sippo.lesson1.dataunit.reader;

import com.examples.skripov.sippo.lesson1.dataunit.DataUnit;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataUnitReader implements AutoCloseable {
    private ObjectInputStream stream;

    public DataUnitReader(String path, String name) throws IOException {
        this(path.concat(name));
    }

    public DataUnitReader(String fullName) throws IOException {
        this(new FileInputStream(fullName));
    }

    public DataUnitReader(FileInputStream fis) throws IOException {
        this(new ObjectInputStream(fis));
    }

    public DataUnitReader(ObjectInputStream stream) {
        this.stream = stream;
    }

    public DataUnit getDataUnit() throws IOException, ClassNotFoundException {
        DataUnit dataUnit = new DataUnit();

        dataUnit.readExternal(stream);

        return dataUnit;
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
