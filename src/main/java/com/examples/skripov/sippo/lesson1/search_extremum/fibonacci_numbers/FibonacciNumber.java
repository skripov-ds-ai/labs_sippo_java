package com.examples.skripov.sippo.lesson1.search_extremum.fibonacci_numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


public class FibonacciNumber {
    public static ArrayList<Long> getFibonacciNumbersVector(int n) {
        ArrayList<Long> fibs = new ArrayList<>();
        fibs.add(1L);
        fibs.add(1L);

        for (int i = 2; i < n; i++) {
            fibs.add(fibs.get(i - 2) + (fibs.get(i - 1)));
        }

        /*for (int i1 = 0; i1 < fibs.size(); i1++) {
            Long i = fibs.get(i1);
            System.out.println("(x = " + i + "; i = " + i1 + ") ");
            if (i1 > 0) {
                if (fibs.get(i1 - 1) < i) {
                    System.out.println("TRUE FIB!");
                } else {
                    System.out.println("FALSE FIB!!");
                }
            }
        }
        System.out.println();*/

        return fibs;
    }
}
