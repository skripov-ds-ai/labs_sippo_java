package com.examples.skripov.sippo.lesson1.helper_classes;

import com.examples.skripov.sippo.lesson1.point2d.Point2D;

public class Interval {
    private Point2D x1, x2;

    public Interval(Point2D x1, Point2D x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Point2D getX1() {
        return x1;
    }

    public Point2D getX2() {
        return x2;
    }

    @Override
    public String toString() {
        return "Interval{\n" +
                "x1=" + x1 +
                "\n, x2=" + x2 +
                '}';
    }
}
