package com.examples.skripov.sippo.lesson2.solver;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.processor.ProblemProcessor;
import com.examples.skripov.sippo.lesson2.problem.reader.ProblemFileReader;
import com.examples.skripov.sippo.lesson2.solver.simplex_table.SimplexTable;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class ArtificialBasicTechniqueSolverTest {
    private Problem problem;
    private Problem problem1;
    private Problem problem2;

    @Before
    public void setUp() throws Exception {
        ArrayList<Fraction> coefficients = new ArrayList<>(Arrays.asList(new Fraction(0), new Fraction(1), new Fraction(2)));
        ObjectiveFunction function = new ObjectiveFunction(Extremum.MAX, coefficients);

        Condition condition1 = new Condition(
                ConditionSign.EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(2),
                        new Fraction(3))),
                new Fraction(1));
        Condition condition2 = new Condition(
                ConditionSign.LESS_OR_EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(4),
                        new Fraction(5))),
                new Fraction(2));
        Condition condition3 = new Condition(
                ConditionSign.MORE_OR_EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(0),
                        new Fraction(1))),
                new Fraction(3));

        problem = ProblemProcessor.makeCanonicalProblem(
                new Problem(function, new ArrayList<>(Arrays.asList(condition1, condition2, condition3)))
        );

        coefficients = new ArrayList<>(Arrays.asList(
                new Fraction(0),
                new Fraction(-2),
                new Fraction(7),
                new Fraction(0),
                new Fraction(-10),
                new Fraction(6)
            )
        );

        function = new ObjectiveFunction(Extremum.MIN, coefficients);

        condition1 = new Condition(
                ConditionSign.EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(-2),
                        new Fraction(1),
                        new Fraction(2),
                        new Fraction(-2),
                        new Fraction(-2)
                )),
                new Fraction(3));
        condition2 = new Condition(
                ConditionSign.EQUAL,
                new ArrayList<>(Arrays.asList(
                        new Fraction(-1),
                        new Fraction(1),
                        new Fraction(-5),
                        new Fraction(-5),
                        new Fraction(3)
                    )
                ),
                new Fraction(8));

        problem1 = ProblemProcessor.makeCanonicalProblem(
                new Problem(function, new ArrayList<>(Arrays.asList(condition1, condition2)))
        );


        File file = new File("src/test/resources/lesson2/problem/reader/src1.txt");

        try (
                ProblemFileReader reader = new ProblemFileReader(file);
        ) {
            problem2 = reader.readProblem();
            System.out.println("!!!! " + ProblemProcessor.countOfVariables(problem2));
            problem2 = ProblemProcessor.makeCanonicalProblem(problem2);
            System.out.println(problem2);
        }
    }



    @Test
    public void testSolve() {
        System.out.println(problem1);

        ArtificialBasicTechniqueSolver solver = new ArtificialBasicTechniqueSolver();
        SimplexTable tableau = solver.solve(problem1);

        System.out.println(tableau.getStringTable());

        System.out.println(tableau.getOptimalValueOfFunction());
        System.out.println(tableau.getOptimalVector());

    }

    @Test
    public void testSolveMyProblem() {
        //throw new IllegalArgumentException();
        ArtificialBasicTechniqueSolver solver = new ArtificialBasicTechniqueSolver();

        //System.out.println(problem2);

        SimplexTable tableau = solver.solve(problem2);

        // todo почему-то есть ненулевые компоненты, которые должны быть нулями!
        System.out.println(tableau.getStringTable());
        System.out.println();
        System.out.println();
        System.out.println(tableau);
        System.out.println();
        System.out.println();

        System.out.println(tableau.getOptimalVector());

        System.out.println(tableau.getOptimalValueOfFunction());
    }

}

/*
1 <= 1
0 1 <= 1
0 0 1 <= 1
0 0 0 1 <= 1
0 0 0 0 1 <= 1
0 0 0 0 0 1 <= 1
0 0 0 0 0 0 1 <= 1
0 0 0 0 0 0 0 1 <= 1
 */
