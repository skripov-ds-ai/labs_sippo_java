package com.examples.skripov.sippo.lesson2.problem;

import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;

import java.util.List;

public class Problem {
    private ObjectiveFunction objectiveFunction;

    private List<Condition> conditions;

    public Problem(ObjectiveFunction objectiveFunction, List<Condition> conditions) {
        this.objectiveFunction = objectiveFunction;
        this.conditions = conditions;
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
}
