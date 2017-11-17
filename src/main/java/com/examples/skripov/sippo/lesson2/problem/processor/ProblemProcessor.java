package com.examples.skripov.sippo.lesson2.problem.processor;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.condition.sign.ConditionSign;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.variable.VariableType;

import java.util.ArrayList;
import java.util.List;

public class ProblemProcessor {
    public static Problem makeCanonicalProblem(Problem problem) {
        int countOfVariables = 0;
        int countOfNotEqualConditions = 0;
        for (Condition condition : problem.getConditions()) {
            countOfVariables = Math.max(countOfVariables, condition.getCoefficients().size());
            if (!condition.getSign().equals(ConditionSign.EQUAL)) {
                countOfNotEqualConditions++;
            }
        }
        ObjectiveFunction function = problem.getObjectiveFunction();
        if (function.getExtremum().equals(Extremum.MIN)) {
            function.negateCoefficients();
        }
        for (int i = 0; i < countOfNotEqualConditions + countOfVariables - (function.getCoefficients().size() - 1); i++) {
            function.addZeroCoefficient();
        }
        int idAdditional = 0;
        boolean addAdditional = true;
        ArrayList<Condition> conditions = problem.getConditions();
        for (int i = 0; i < conditions.size(); i++) {
            for (int j = 0; j < countOfVariables - conditions.get(i).getCoefficients().size(); j++) {
                conditions.get(i).addCoefficient(Fraction.ZERO, VariableType.NORM);
            }
            if (conditions.get(i).getSign().equals(ConditionSign.MORE_OR_EQUAL)) {
                conditions.get(i).negateCoefficients();
            }
            if (conditions.get(i).getSign().equals(ConditionSign.EQUAL)) {
                for (int j = 0; j < countOfNotEqualConditions; j++) {
                    conditions.get(i).addCoefficient(Fraction.ZERO, VariableType.ADDITIONAL);
                }
            } else {
                for (int j = 0; j < countOfNotEqualConditions; j++) {
                    if (addAdditional && j == idAdditional) {
                        conditions.get(i).addCoefficient(Fraction.ONE, VariableType.ADDITIONAL);
                        addAdditional = false;
                        idAdditional++;
                    } else {
                        conditions.get(i).addCoefficient(Fraction.ZERO, VariableType.ADDITIONAL);
                    }
                }
            }
            addAdditional = true;
        }
        return new Problem(function, conditions);
    }
}
