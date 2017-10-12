package com.examples.skripov.sippo.lesson1.reader;

import java.io.IOException;

public interface IReader {
    String readLine() throws IOException;
    int readInt() throws IOException;
    double readDouble() throws IOException;
    long readLong() throws IOException;
    float readFloat() throws IOException;
    boolean readBoolean() throws IOException;
}
