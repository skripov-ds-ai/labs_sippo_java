package com.examples.skripov.sippo.lesson2.problem.objective.function.extremum;

import com.examples.skripov.sippo.lesson2.problem.objective.function.extremum.exception.NotSupportExtremumStringException;

import java.util.HashSet;

public class ExtremumStringHelper {
    private final static String MAX = "MAX";
    private final static String MIN = "MIN";

    private static HashSet<String> set;

    static {
        set.add(MAX);
        set.add(MIN);
    }

    public static Extremum getConditionSign(String s) throws NotSupportExtremumStringException {
        if (set.contains(s)) {
            throw new NotSupportExtremumStringException();
        }

        switch (s) {
            case MAX: {
                return Extremum.MAX;
            }
            case MIN: {
                return Extremum.MIN;
            }
            default: {
                throw new NotSupportExtremumStringException();
            }
        }
    }
}
