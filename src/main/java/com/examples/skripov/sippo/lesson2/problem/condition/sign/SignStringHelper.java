package com.examples.skripov.sippo.lesson2.problem.condition.sign;

import com.examples.skripov.sippo.lesson2.problem.condition.sign.exception.NotSupportedSignException;

import java.util.HashSet;

public final class SignStringHelper {
    public final static String EQUAL = "=";
    public final static String LESS_OR_EQUAL = "<=";
    public final static String MORE_OR_EQUAL = ">=";

    private static HashSet<String> set;

    static {
        set.add(EQUAL);
        set.add(LESS_OR_EQUAL);
        set.add(MORE_OR_EQUAL);
    }

    public static ConditionSign getConditionSign(String s) throws NotSupportedSignException {
        if (set.contains(s)) {
            throw new NotSupportedSignException();
        }

        switch (s) {
            case EQUAL: {
                return ConditionSign.EQUAL;
            }
            case LESS_OR_EQUAL: {
                return ConditionSign.LESS_OR_EQUAL;
            }
            case MORE_OR_EQUAL: {
                return ConditionSign.MORE_OR_EQUAL;
            }
            default: {
                throw new NotSupportedSignException();
            }
        }
    }
}
