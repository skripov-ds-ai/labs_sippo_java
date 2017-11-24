package com.examples.skripov.sippo.lesson2.solver;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.processor.ProblemProcessor;
import com.examples.skripov.sippo.lesson2.problem.variable.VariableType;
import com.examples.skripov.sippo.lesson2.solver.simplex_table.SimplexTable;

import java.util.ArrayList;
import java.util.List;

public final class ArtificialBasicTechniqueSolver {

    public final void solve(Problem problem) {
        ArrayList<Condition> conditions = problem.getConditions();

        ArrayList<Fraction> hCoef = new ArrayList<>();

        hCoef.add(new Fraction(0));
        for (int j = 0; j < conditions.size(); j++) {
            System.out.println("free = " + conditions.get(j).getFreeFactor());
            hCoef.get(0).sub(conditions.get(j).getFreeFactor());
        }

        for (int i = 0; i < ProblemProcessor.countOfVariables(problem); i++) {
            hCoef.add(new Fraction(0));
            //System.out.println("### " + hCoef);
            for (int j = 0; j < conditions.size(); j++) {
                //if (i == 0) {
                //    hCoef.get(i).sub(conditions.get(j).getFreeFactor());
                //} else {
                System.out.println("ji = "+ conditions.get(j).getCoefficients().get(i));
                    hCoef.get(i + 1).add(conditions.get(j).getCoefficients().get(i));
                //}
            }
        }

        System.out.println("coefs = "+hCoef);

        ObjectiveFunction h = new ObjectiveFunction(Extremum.MAX, hCoef);

        //for (int i = 0; i < conditions.size(); i++) {
        //    conditions.get(i).negateVarCoefficients();
        //}

        Problem problem1 = new Problem(h, conditions);

        System.out.println("ArtifProblem = "+problem1);

        SimplexTable artificialTableau = new SimplexTable(problem1);

        for (int i = 0; i < conditions.size(); i++) {
            artificialTableau.associateRowIndex2String(i + 1, "t" + (i + 1));
            artificialTableau.associateStringWithVariableType("t" + (i + 1), VariableType.ARTIFICIAL);
        }

        ArrayList<VariableType> types = conditions.get(0).getTypes();

        for (int j = 1; j < hCoef.size(); j++) {
            artificialTableau.associateColumnIndex2String(j, "x" + j);
            artificialTableau.associateStringWithVariableType("x" + j, types.get(j - 1));
        }

        System.out.println(artificialTableau.getStringTable());
        System.out.println("\nallTable = " + artificialTableau);
        System.out.println();

        System.out.println(artificialTableau.isForwardOptimal());
        System.out.println(artificialTableau.isUnSolvable(1));

        artificialTableau.relaxTableau(2, 2);
        System.out.println("new tableau:");
        System.out.println(artificialTableau.getStringTable());

        System.out.println(artificialTableau.isForwardOptimal());

        System.out.println("\nallTable = " + artificialTableau);
        System.out.println();



    }
}
