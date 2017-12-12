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
    private Problem problem;
    private BiMap<Integer, String> rowsMap;
    private BiMap<Integer, String> columnsMap;
    private HashMap<String, VariableType> variableTypeMap;

    public Problem getProblem() {
        return problem;
    }

    private List<List<Fraction>> tableau;

    public SimplexTable(Problem problem) {
        rowsMap = new BiMap<>();
        columnsMap = new BiMap<>();
        variableTypeMap = new HashMap<>();
        this.problem = problem;

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

    public BiMap<Integer, String> getRowsMap() {
        return rowsMap;
    }

    public BiMap<Integer, String> getColumnsMap() {
        return columnsMap;
    }

    public HashMap<String, VariableType> getVariableTypeMap() {
        return variableTypeMap;
    }

    public List<List<Fraction>> getTableau() {
        return tableau;
    }

    public Fraction getOptimalValueOfFunction() {
        if (problem.isWasMin()) {
            return getElem(0, 0).negating();
        }
        return getElem(0, 0).identity();
    }

    public List<Fraction> getOptimalVector() {
        System.out.println("VECTOR!!!");
        Map<String, Fraction> map = new HashMap<>();

        Map<String, Integer> rows = (new HashMap<>());
        rows.putAll(rowsMap.getM2t());

        int tmp = 0;

        for (Map.Entry<String, Integer> entry : rows.entrySet()) {
            System.out.println(entry);
            System.out.println(variableTypeMap.get(entry.getKey()));
            System.out.println(tableau.get(entry.getValue()).get(0));
            System.out.println(variableTypeMap.get(entry.getKey()).equals(VariableType.NORM));
            System.out.println();
            if (variableTypeMap.get(entry.getKey()).equals(VariableType.NORM)) {
                map.put(entry.getKey(), tableau.get(entry.getValue()).get(0));
                //tmp++;
            }

            //System.out.println("TMP = " + tmp);
        }

        //System.out.println("SIZE:");
        //System.out.println(problem.getObjectiveFunction().getCoefficients().size() - 1);
        //System.out.println();
        //System.out.println(rows);

        int sizeOfVector = problem.getNormVariables().size();//problem.getObjectiveFunction().().size() - 1;

        List<Fraction> answer = new ArrayList<>();
        for (int i = 0; i < sizeOfVector; i++) {
            answer.add(new Fraction(0));
        }

        for (Map.Entry<String, Fraction> entry : map.entrySet()) {
            if (variableTypeMap.get(entry.getKey()).equals(VariableType.NORM)) {
                int id = Integer.parseInt(entry.getKey().substring(1)) - 1;
                answer.get(id).add(entry.getValue());
            }
        }

        return answer;
    }

    public List<Fraction> getFunctionCoefs() {
        return tableau.get(0);
    }

    public List<Fraction> getIthRow(int i) {
        return tableau.get(i);
    }

    public Fraction getElem(int i, int j) {
        return tableau.get(i).get(j);
    }

    //public Integer keyJ() {
//
    //}

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

    public int rowsCount() {
        return tableau.size();
    }

    public int columnsCount() {
        return tableau.get(0).size();
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
                        /*if (i == 0) {
                            System.out.println("elem = " + forChange);
                        }*/
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


        if (variableTypeMap.get(columnsMap.getM(q)).equals(VariableType.ARTIFICIAL)) {
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
            System.out.println("q = " + q);
            //columnsMap.removeM(columnsMap.getM(q));
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

    public void reduce() {
        //ArrayList<String> toDelete = new ArrayList<>();
       // for (Map.Entry<String, Integer> entry : columnsMap.getM2t().entrySet()) {
       //     if (variableTypeMap.get(entry.getKey()).equals(VariableType.ARTIFICIAL)) {
       //         toDelete.add(entry.getKey() + "");
       //     }
       // }
        //System.out.println(columnsMap.getM2t().entrySet().size());
        //System.out.println("toDelete = " + toDelete);
        //System.out.println(tableau.get(0).size());
        //for (String s : toDelete) {
        //    columnsMap.removeM(s);
        //}
        /*for (String s : toDelete) {
            int q = columnsMap.getT(s) - 1;
            for (int j = q + 1; j < tableau.get(0).size(); j++) {
                String name = columnsMap.getM(j);
                columnsMap.removeT(j - 1);
                columnsMap.removeM(name);
                columnsMap.add(j - 1, name);
            }
            for (List<Fraction> aTableau : tableau) {
                aTableau.remove(q);
            }
        }*/

    }

    private void changeRowAndColumnStrings(int i, int j) {
        System.out.println("Before:");
        System.out.println("Rows:");
        System.out.println(rowsMap);
        System.out.println("Columns:");
        System.out.println(columnsMap);
        System.out.println("---------");

        String iS = rowsMap.getM(i);
        String jS = columnsMap.getM(j);

        rowsMap.removeM(iS);
        columnsMap.removeM(jS);

        rowsMap.add(i, jS);
        columnsMap.add(j, iS);

        System.out.println("After:");
        System.out.println("Rows:");
        System.out.println(rowsMap);
        System.out.println("Columns:");
        System.out.println(columnsMap);
        System.out.println("---------");
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
