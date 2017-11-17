package com.examples.skripov.sippo.lesson2.problem.reader;

import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.reader.ConditionStringReader;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.reader.ObjectiveFunctionStringReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public Problem readProblem() throws Exception {
        Problem problem = null;

        ObjectiveFunction function = null;

        {
            //try(
            ObjectiveFunctionStringReader reader = new ObjectiveFunctionStringReader(this.reader.readLine());
            //) {
            function = reader.readObjectiveFunction();
            //}
        }

        List<Condition> conditions = new ArrayList<>();

        String src = null;
        while ((src = reader.readLine()) != null) {
            {
            //try (
                    ConditionStringReader reader = new ConditionStringReader(src);
            //) {
                conditions.add(reader.readCondition());
            }
        }

        problem = new Problem(function, conditions);

        return problem;
    }

    @Override
    public void close() throws Exception {
        reader.close();
    }
}
