package com.examples.skripov.sippo.lesson2.problem;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.variable.VariableType;

import java.util.*;

public class Problem {
    private ObjectiveFunction objectiveFunction;

    private ArrayList<Condition> conditions;
    private Set<String> normVariables;

    private boolean wasMin = false;

    public Problem(ObjectiveFunction objectiveFunction, ArrayList<Condition> conditions, Set<String> normVariables) {
        this(objectiveFunction, conditions);
        this.normVariables = normVariables;
    }

    public Problem(ObjectiveFunction objectiveFunction, ArrayList<Condition> conditions) {
        //System.out.println("f = "+objectiveFunction);
        this.objectiveFunction = objectiveFunction;
        this.conditions = conditions;
        //largerIndexOfVariable = 0;
        //for (Condition condition : conditions) {
        //    int tmp = condition.getMaxIndexOfVariable();
        //    if (largerIndexOfVariable < tmp) {
        //        largerIndexOfVariable = tmp;
        //    }
        //}
    }

    //public final int getLargerIndexOfVariable() {
    //   return largerIndexOfVariable;
    //}


    public void setWasMin(boolean wasMin) {
        this.wasMin = wasMin;
    }

    public boolean isWasMin() {
        return wasMin;
    }

    public final void createNormVariables() {
        normVariables = new HashSet<>();
    }

    public final void addNormalName(String name) {
        normVariables.add(name);
    }

    public final Set<String> getNormVariables() {
        return normVariables;
    }

    public final void setNormVariables(Set<String> normVariables) {
        this.normVariables = normVariables;
    }

    public final ObjectiveFunction getObjectiveFunction() {
        return objectiveFunction;
    }

    public final void setObjectiveFunction(ObjectiveFunction objectiveFunction) {
        this.objectiveFunction = objectiveFunction;
    }

    public final ArrayList<Condition> getConditions() {
        return conditions;
    }

    public final void setConditions(ArrayList<Condition> conditions) {
        this.conditions = conditions;
    }

    public final void addArtificialVariables() {
        for (int i = 0; i < conditions.size(); i++) {
            for (int j = 0; j < conditions.size(); j++) {
                if (i == j) {
                    addVariable2Condition(i, new Fraction(1), VariableType.ARTIFICIAL);
                } else {
                    addVariable2Condition(i, new Fraction(0), VariableType.ARTIFICIAL);
                }
            }
        }
    }

    private final void addVariable2Condition(int index, Fraction a, VariableType type) {
        conditions.get(index).addCoefficient(a, type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Problem problem = (Problem) o;

        if (objectiveFunction != null ? !objectiveFunction.equals(problem.objectiveFunction) : problem.objectiveFunction != null)
            return false;
        return conditions != null ? conditions.equals(problem.conditions) : problem.conditions == null;
    }

    @Override
    public int hashCode() {
        int result = objectiveFunction != null ? objectiveFunction.hashCode() : 0;
        result = 31 * result + (conditions != null ? conditions.hashCode() : 0);
        return result;
    }

    private static String conditionsToString(List<Condition> conditions) {
        StringJoiner result = new StringJoiner(" ");

        for (Condition condition : conditions) {
            result.add(condition.toString());
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return "Problem{" +
                "objectiveFunction=" + objectiveFunction +
                ", conditions=" + conditions +
                ", normVariables=" + normVariables +
                ", wasMin=" + wasMin +
                '}';
    }
}
