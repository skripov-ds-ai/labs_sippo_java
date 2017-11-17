package com.examples.skripov.sippo.lesson2.problem;

import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;

import java.util.List;
import java.util.StringJoiner;

public class Problem {
    private ObjectiveFunction objectiveFunction;

    private List<Condition> conditions;
    private int largerIndexOfVariable;

    public Problem(ObjectiveFunction objectiveFunction, List<Condition> conditions) {
        this.objectiveFunction = objectiveFunction;
        this.conditions = conditions;
        largerIndexOfVariable = 0;
        for (Condition condition : conditions) {
            int tmp = condition.getMaxIndexOfVariable();
            if (largerIndexOfVariable < tmp) {
                largerIndexOfVariable = tmp;
            }
        }
    }

    public final int getLargerIndexOfVariable() {
        return largerIndexOfVariable;
    }

    public final ObjectiveFunction getObjectiveFunction() {
        return objectiveFunction;
    }

    public final void setObjectiveFunction(ObjectiveFunction objectiveFunction) {
        this.objectiveFunction = objectiveFunction;
    }

    public final List<Condition> getConditions() {
        return conditions;
    }

    public final void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
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
                ", conditions=" + conditionsToString(conditions) +
                '}';
    }
}
