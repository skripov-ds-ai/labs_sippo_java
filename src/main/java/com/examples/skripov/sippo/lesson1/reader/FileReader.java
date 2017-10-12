package com.examples.skripov.sippo.lesson1.reader;

import java.io.*;
import java.nio.charset.Charset;

import static com.examples.skripov.sippo.lesson1.constants.Encoding.*;

public class FileReader implements IReader, AutoCloseable {
    private InputStream fileStream;
    private BufferedReader fileReader;
    private String path;
    private String name;
    private Charset charset;

    public FileReader(String path, String name) {
        this.path = path;
        this.name = name;

        try {
            File file = new File(path, name);
            fileStream = new FileInputStream(file);
            charset = Charset.forName(UTF_8);
            fileReader = new BufferedReader(new InputStreamReader(fileStream, charset));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String readLine() throws IOException {
        return fileReader.readLine();
    }

    @Override
    public int readInt() throws IOException {
        return Integer.valueOf(String.valueOf(fileReader.readLine()));
    }

    @Override
    public double readDouble() throws IOException {
        return Double.valueOf(String.valueOf(fileReader.readLine()));

    }

    @Override
    public long readLong() throws IOException {
        return Long.valueOf(String.valueOf(fileReader.readLine()));
    }

    @Override
    public float readFloat() throws IOException {
        return Float.valueOf(String.valueOf(fileReader.readLine()));
    }

    @Override
    public boolean readBoolean() throws IOException {
        return Boolean.valueOf(String.valueOf(fileReader.readLine()));
    }

    @Override
    public void close() throws Exception {
        fileStream.close();
        fileReader.close();
    }
}
