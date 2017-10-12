package com.examples.skripov.sippo.lesson1.writer;

import java.io.*;
import java.nio.charset.Charset;

import static com.examples.skripov.sippo.lesson1.constants.Encoding.UTF_8;

public class FileWriter implements IWriter, AutoCloseable {
    private OutputStream fileStream;
    private BufferedWriter fileWriter;
    private String path;
    private String name;
    private Charset charset;

    public FileWriter(String path, String name) {
        this.path = path;
        this.name = name;

        try {
            File file = new File(path, name);
            fileStream = new FileOutputStream(file);
            charset = Charset.forName(UTF_8);
            fileWriter = new BufferedWriter(new OutputStreamWriter(fileStream, UTF_8));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(String s) throws IOException {
        fileWriter.write(s);
        fileWriter.flush();
    }

    @Override
    public void close() throws Exception {
        fileStream.close();
        fileWriter.close();
    }
}
