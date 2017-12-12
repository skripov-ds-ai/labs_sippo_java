package com.examples.skripov.sippo.lesson2.problem.processor;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.variable.VariableType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ProblemProcessor {
    public static int countOfVariables(Problem problem) {
        int countOfVariables = 0;
        for (Condition condition : problem.getConditions()) {
            countOfVariables = Math.max(countOfVariables, condition.getCoefficients().size());
        }
        return countOfVariables;
    }

    public static Problem makeCanonicalProblem(Problem problem) {
        int countOfVariables = 0;
        int countOfNotEqualConditions = 0;
        for (Condition condition : problem.getConditions()) {
            countOfVariables = Math.max(countOfVariables, condition.getCoefficients().size());
            if (!condition.getSign().equals(ConditionSign.EQUAL)) {
                countOfNotEqualConditions++;
            }
        }

        //countOfVariables--;

        HashSet<String> normVars = new HashSet<>();
        for (int i = 0; i < countOfVariables; i++) {
            normVars.add("x"+i);
        }

        ObjectiveFunction function = problem.getObjectiveFunction();
        //System.out.println(function);
        if (function.getExtremum().equals(Extremum.MIN)) {
            problem.setWasMin(true);
            function.negateCoefficients();
            //System.out.println(function);
        }
        int m = function.getCoefficients().size() - 1;
        for (int i = 0; i < countOfNotEqualConditions + countOfVariables - m; i++) {
            function.addZeroCoefficient();
        }
        int idAdditional = 0;
        boolean addAdditional = true;
        ArrayList<Condition> conditions = problem.getConditions();

        //System.out.println("Count of vars = " + countOfVariables);
        //System.out.println("Count of notEqual = " + countOfNotEqualConditions);

        for (int i = 0; i < conditions.size(); i++) {
            //System.out.println("Before!:");
            //System.out.println(conditions.get(i).getCoefficients().size());
            //System.out.println("\n");

            //System.out.println("Add norm!");
            //System.out.println(countOfVariables - conditions.get(i).getCoefficients().size());
            //System.out.println();
            int n = conditions.get(i).getCoefficients().size();
            for (int j = 0; j < countOfVariables - n; j++) {
                conditions.get(i).addCoefficient(new Fraction(0), VariableType.NORM);
            //    System.out.println("Size = " + conditions.get(i).getCoefficients().size());
            }
            //System.out.println("AFTER!");
            //System.out.println(conditions.get(i).getCoefficients().size());
            //System.out.println("\n");

            if (conditions.get(i).getSign().equals(ConditionSign.MORE_OR_EQUAL)) {
                conditions.get(i).negateCoefficients();
            }
            if (conditions.get(i).getSign().equals(ConditionSign.EQUAL)) {
                for (int j = 0; j < countOfNotEqualConditions; j++) {
                    conditions.get(i).addCoefficient(new Fraction(0), VariableType.ADDITIONAL);
                }
            } else {
                for (int j = 0; j < countOfNotEqualConditions; j++) {
                    if (addAdditional && j == idAdditional) {
                        conditions.get(i).addCoefficient(new Fraction(1), VariableType.ADDITIONAL);
                        addAdditional = false;
                        idAdditional++;
                    } else {
                        conditions.get(i).addCoefficient(new Fraction(0), VariableType.ADDITIONAL);
                    }
                }
            }
            addAdditional = true;
        }

        //for (int i = 0; i < conditions.size(); i++) {
        //    System.out.println("size of " + i + " cond = " + conditions.get(i).getCoefficients().size());
        //}

        //System.out.println("1!!");
        //System.out.println(function);

        return new Problem(function, conditions, normVars);
    }
}
