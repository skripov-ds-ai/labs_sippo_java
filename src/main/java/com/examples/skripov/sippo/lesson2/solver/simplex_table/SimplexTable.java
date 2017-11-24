package com.examples.skripov.sippo.lesson2.solver.simplex_table;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.variable.VariableType;
import com.examples.skripov.sippo.lesson2.solver.simplex_table.bimap.BiMap;

import java.util.*;

// todo: make it Cloneable
public class SimplexTable  {
    private BiMap<Integer, String> rowsMap;
    private BiMap<Integer, String> columnsMap;
    private HashMap<String, VariableType> variableTypeMap;

    private List<List<Fraction>> tableau;

    public SimplexTable(Problem problem) {
        rowsMap = new BiMap<>();
        columnsMap = new BiMap<>();
        variableTypeMap = new HashMap<>();

        tableau = new ArrayList<>();

        ObjectiveFunction function = problem.getObjectiveFunction();
        ArrayList<Fraction> f = function.getCoefficientsForTable();

        //System.out.println("Simp f = " + f);

        tableau.add(f);

        int id = 0;

        List<Condition> conditions = problem.getConditions();
        for (Condition condition : conditions) {
            ArrayList<Fraction> tmp = new ArrayList<>();
            tmp.add(condition.getFreeFactor());
            tmp.addAll(condition.getCoefficients());

            tableau.add(tmp);

        }
    }

    public void associateRowIndex2String(Integer index, String s) {
        rowsMap.add(index, s);
    }

    public void associateColumnIndex2String(Integer index, String s) {
        columnsMap.add(index, s);
    }

    public void associateStringWithVariableType(String s, VariableType type) {
        variableTypeMap.put(s, type);
    }

    public boolean isUnSolvable(int id) {
        for (List<Fraction> row : tableau) {
            if (row.get(id).compareTo(new Fraction(0)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isForwardOptimal() {
        int id = 0;
        for (Fraction coef : tableau.get(0)) {
            if (id != 0) {
                if (coef.compareTo(new Fraction(0)) < 0) {
                    return false;
                }
            }
            id++;
        }
        return true;
    }

    public void relaxTableau(int p, int q) {
        changeRowAndColumnStrings(p, q);

        Fraction pivot = tableau.get(p).get(q);
        for (int i = 0; i < tableau.size(); i++) {
            if (i != p) {
                for (int j = 0; j < tableau.get(i).size(); j++) {
                    if (j != q) {
                        Fraction forChange = tableau.get(i).get(j);
                        Fraction delta = tableau.get(i).get(q).multiplication(tableau.get(p).get(j)).division(pivot);
                        forChange.sub(delta);
                    }
                }
            }
        }


        for (int j = 0; j < tableau.get(p).size(); j++) {
            if (j != q) {
                Fraction forChange = tableau.get(p).get(j);
                forChange.div(pivot);
            }
        }

        if (variableTypeMap.get(columnsMap.getM(q)) == VariableType.ARTIFICIAL) {
            // delete artificial column
            for (int j = q + 1; j < tableau.get(0).size(); j++) {
                String name = columnsMap.getM(j);
                columnsMap.removeT(j - 1);
                columnsMap.removeM(name);
                columnsMap.add(j - 1, name);
            }
            for (List<Fraction> aTableau : tableau) {
                aTableau.remove(q);
            }
        } else {
            for (int i = 0; i < tableau.size(); i++) {
                if (i != p) {
                    Fraction forChange = tableau.get(i).get(q);
                    forChange.div(pivot);
                    forChange.negate();
                }
            }

            pivot.reverse();
        }
    }

    private void changeRowAndColumnStrings(int i, int j) {
        String iS = rowsMap.getM(i);
        String jS = columnsMap.getM(j);

        rowsMap.removeM(iS);
        columnsMap.removeM(jS);

        rowsMap.add(i, jS);
        columnsMap.add(j, iS);
    }

    public String getStringTable() {
        StringJoiner s = new StringJoiner("\n");
        for (List<Fraction> row : tableau) {
            s.add(row.toString());
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "SimplexTable{" +
                "rowsMap=" + rowsMap +
                ", columnsMap=" + columnsMap +
                ", variableTypeMap=" + variableTypeMap +
                ", tableau=" + tableau +
                '}';
    }
}
