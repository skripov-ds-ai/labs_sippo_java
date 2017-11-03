package com.examples.skripov.sippo.lesson2.problem.reader;

import com.examples.skripov.sippo.lesson2.problem.Problem;

import java.io.*;

public class ProblemFileReader implements AutoCloseable {
    BufferedReader reader;

    public ProblemFileReader(String path) throws FileNotFoundException {
        this(new File(path));
    }

    public ProblemFileReader(String path, String name) throws FileNotFoundException {
        this(new File(path, name));
    }

    public ProblemFileReader(File file) throws FileNotFoundException {
        reader = new BufferedReader(
                new FileReader(file)
        );
    }

    public Problem read() throws IOException {
        Problem problem;



        return null;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
