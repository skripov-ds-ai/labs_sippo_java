package com.examples.skripov.sippo.lesson2.solver;

import com.examples.skripov.sippo.lesson2.fraction.Fraction;
import com.examples.skripov.sippo.lesson2.problem.Problem;
import com.examples.skripov.sippo.lesson2.problem.condition.Condition;
import com.examples.skripov.sippo.lesson2.problem.objective.function.ObjectiveFunction;
import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.Extremum;
import com.examples.skripov.sippo.lesson2.problem.processor.ProblemProcessor;
import com.examples.skripov.sippo.lesson2.problem.variable.VariableType;
import com.examples.skripov.sippo.lesson2.solver.simplex_table.SimplexTable;

import java.util.*;

public final class ArtificialBasicTechniqueSolver {

    private final SimplexTable solveForward(SimplexTable tableau) {
        Fraction zero = new Fraction(0);


        //int it = 0;
        while (true) {
            System.out.println(tableau.getStringTable());
            System.out.println();


            if (tableau.isForwardOptimal()) {
                break;
            }

            List<Fraction> cs = tableau.getFunctionCoefs();
            //Fraction key = artificialTableau.getElem(1, 0).division(artificialTableau.getElem());
            int q = 0;
            for (int j = 1; j < cs.size(); j++) {
                if (cs.get(j).compareTo(zero) < 0) {
                    //System.out.println("c[j] = " + cs.get(j));
                    q = j;
                    break;
                }
            }

            //System.out.println("q = " + q);

            //if (artificialTableau.isUnSolvable(q)) {
            //    throw new IllegalArgumentException();
            //}

            if (q == 0) {
                throw new IllegalArgumentException();
            }

            if (tableau.isUnSolvable(q)) {
                throw new IllegalArgumentException();
            }

            // todo rewrite this logic for choosing to 2 steps!
            // todo + разберись с проблемой в гамсе!
            //int p = 0;
            //Fraction key = zero;

            ArrayList<Integer> ids = new ArrayList<>();

            for (int i = 1; i < tableau.rowsCount(); i++) {
                if (tableau.getElem(i, q).compareTo(zero) > 0) {
                    ids.add(i);
                }
            }

            if (ids.size() < 1) {
                throw new IllegalArgumentException();
            }

            int p = ids.get(0);
            for (Integer id : ids) {
                if ( (new Fraction(tableau.getElem(id, 0))).division(tableau.getElem(id, q))
                        .compareTo((new Fraction(tableau.getElem(p, 0))).division(tableau.getElem(p, q))) < 0 ) {
                    p = id;
                }
            }


            /*boolean first = true;
            // todo! and try to rewrite condition for problem(for your problem!)!
            for (int i = 1; i < tableau.rowsCount(); i++) {
                if (tableau.getElem(i, q).compareTo(zero) <= 0) {
                    continue;
                }
                Fraction tmp = (new Fraction(tableau.getElem(i, 0))).division(tableau.getElem(i, q));
                System.out.println("tmp = "+tmp);
                if (key.compareTo(zero) > 0) {
                    if (tmp.compareTo(key) < 0) {
                        key = tmp;
                        p = i;
                        //first = false;
                    }
                    continue;
                }
                if (key.compareTo(zero) == 0) {// || first) {
                    key = tmp;
                    p = i;
                    first = false;
                }
                System.out.println("key = "+key);
            }*/

            //System.out.println(tableau.getStringTable());

            //if (key.compareTo(zero) <= 0) {
            //    throw new IllegalArgumentException();
            //}

            //System.out.println("p = " + p);

            if (p <= 0) {
                throw new IllegalArgumentException();
            }

            //System.out.println("p = " + p + "; q = " + q);
            tableau.relaxTableau(p, q);

            //System.out.println();
            //System.out.println(tableau.getStringTable());
            //System.out.println();

            //it++;
            //if (it == 4) {
            //    break;
            //}
            //break;
        }

        return tableau;
    }

    public final SimplexTable solve(Problem problem) {
        //System.out.println(problem.getObjectiveFunction());

        ArrayList<Condition> conditions = problem.getConditions();

        ArrayList<Fraction> hCoef = new ArrayList<>();

        hCoef.add(new Fraction(0));
        for (int j = 0; j < conditions.size(); j++) {
            //System.out.println("free = " + conditions.get(j).getFreeFactor());
            hCoef.get(0).sub(conditions.get(j).getFreeFactor());
        }

        for (int i = 0; i < ProblemProcessor.countOfVariables(problem); i++) {
            hCoef.add(new Fraction(0));
            //System.out.println("### " + hCoef);
            for (int j = 0; j < conditions.size(); j++) {
                //if (i == 0) {
                //    hCoef.get(i).sub(conditions.get(j).getFreeFactor());
                //} else {
                //System.out.println(j + "coefs size = " + conditions.get(j).getCoefficients().size());
                //System.out.println("ji = "+ conditions.get(j).getCoefficients().get(i));
                hCoef.get(i + 1).add(conditions.get(j).getCoefficients().get(i));
                //}
            }
        }

        //System.out.println("coefs = "+hCoef);

        ObjectiveFunction h = new ObjectiveFunction(Extremum.MAX, hCoef);

        //for (int i = 0; i < conditions.size(); i++) {
        //    conditions.get(i).negateVarCoefficients();
        //}

        Problem problem1 = new Problem(h, conditions, problem.getNormVariables());

        Fraction zero = new Fraction(0);

        //System.out.println("ArtifProblem = "+problem1);

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

        //System.out.println(artificialTableau.getStringTable());
        //System.out.println("\nallTable = " + artificialTableau);
        //System.out.println();

        //System.out.println(artificialTableau.isForwardOptimal());
        //System.out.println(artificialTableau.isUnSolvable(1));

        //artificialTableau.relaxTableau(1, 2);
        //System.out.println("new tableau:");
        //System.out.println(artificialTableau.getStringTable());

        //System.out.println(artificialTableau.isForwardOptimal());

        //System.out.println("\nallTable = " + artificialTableau);
        //System.out.println();

        //artificialTableau.relaxTableau(2, 1);


        //System.out.println(artificialTableau.getStringTable());



        //System.out.println(artificialTableau.getStringTable());

        artificialTableau = solveForward(artificialTableau);

        if (artificialTableau.getOptimalValueOfFunction().compareTo(new Fraction(0)) > 0) {
            throw new IllegalArgumentException();
        }

        System.out.println("columns map!!!");
        System.out.println(artificialTableau.getColumnsMap());
        System.out.println();
        int newFSize = artificialTableau.columnsCount();
        ArrayList<Fraction> newFCoefs = new ArrayList<>();
        for (int i = 0; i < newFSize; i++) {
            newFCoefs.add(new Fraction(0));
            //System.out.println(newFCoefs.get(i));
        }

        List<Fraction> originalFCoefs = problem.getObjectiveFunction().getCoefficientsForTable();

        Set<Integer> indexes = new HashSet<>();
        for (int i = 1; i < originalFCoefs.size(); i++) {
            if (originalFCoefs.get(i).compareTo(zero) != 0) {
                indexes.add(i);
            }
        }

        System.out.println(artificialTableau.getStringTable());
        System.out.println("indexes = " + indexes);

        Map<String, Integer> rows = artificialTableau.getRowsMap().getM2t();
        for (Map.Entry<String, Integer> entry : rows.entrySet()){
            if (entry.getKey().startsWith("t")) {
                continue;
            }
            Integer id = Integer.parseInt(entry.getKey().substring(1));

            indexes.remove(id);
            System.out.println(id);

            List<Fraction> row = artificialTableau.getIthRow(entry.getValue());

            System.out.println("row = " +row);

            Fraction coef = originalFCoefs.get(id);

            System.out.println("coef = " + coef);

            for (int j = 0; j < newFSize; j++) {
                newFCoefs.get(j).sub/*add*/(row.get(j).multiplication(coef));
            }

            if (indexes.size() < 1) {
                break;
            }
        }

        System.out.println(indexes);

        Map<String, Integer> columns = artificialTableau.getColumnsMap().getM2t();

        System.out.println("######columns = " + columns);

        for (Integer id : indexes) {
            int k = columns.get("x" + id);
            System.out.println("columns.get(x" + id + ") = " + columns.get("x" + id));
            //System.out.println(k);
            newFCoefs.get(k).add(originalFCoefs.get(id));
        }


        //System.out.println("newCoefs:");
        //System.out.println(newFCoefs);

        artificialTableau.getTableau().remove(0);
        artificialTableau.getTableau().add(0, newFCoefs);

        System.out.println("PROBLEM!");
        System.out.println(artificialTableau.getProblem());
        System.out.println(artificialTableau.getProblem().getNormVariables());

        artificialTableau.reduce();

        artificialTableau = solveForward(artificialTableau);

        return artificialTableau;
    }
}
