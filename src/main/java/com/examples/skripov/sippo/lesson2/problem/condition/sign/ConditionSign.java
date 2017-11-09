package com.examples.skripov.sippo.lesson2.problem.condition.sign;

public enum ConditionSign {
    EQUAL(SignStringHelper.EQUAL),
    MORE_OR_EQUAL(SignStringHelper.MORE_OR_EQUAL),
    LESS_OR_EQUAL(SignStringHelper.LESS_OR_EQUAL);

    ConditionSign(String s) {

    }


    @Override
    public String toString() {
        return super.toString();
    }
}
