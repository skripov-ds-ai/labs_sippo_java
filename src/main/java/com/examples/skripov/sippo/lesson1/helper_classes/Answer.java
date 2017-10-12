package com.examples.skripov.sippo.lesson1.helper_classes;

public class Answer {
    private Interval interval;
    private double fStar;

    public Answer(Interval interval, double fStar) {
        this.interval = interval;
        this.fStar = fStar;
    }

    public Interval getInterval() {
        return interval;
    }

    public double getfStar() {
        return fStar;
    }

    @Override
    public String toString() {
        return "Answer{\n" +
                "interval=" + interval +
                "\n, fStar=" + fStar +
                '}';
    }
}
