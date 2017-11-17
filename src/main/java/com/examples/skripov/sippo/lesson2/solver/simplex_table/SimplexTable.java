package com.examples.skripov.sippo.lesson2.solver.simplex_table;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.solver.simplex_table.bimap.BiMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// todo: make it Cloneable
public class SimplexTable  {
    private BiMap<Integer, String> rowsMap;
    private BiMap<Integer, String> columnsMap;

    private List<List<Fraction>> tableau;


    public boolean isUnSolvable(int id) {
        for (List<Fraction> row : tableau) {
            if (row.get(id).compareTo(Fraction.ZERO) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isForwardOptimal() {
        int id = 0;
        for (Fraction coef : tableau.get(0)) {
            if (id != 0) {
                if (coef.compareTo(Fraction.ZERO) < 0) {
                    return false;
                }
            }
            id++;
        }
        return true;
    }
}
