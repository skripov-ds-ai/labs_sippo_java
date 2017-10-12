package com.examples.skripov.sippo.lesson2.simplex_table;

public class SimplexTable {
    private int height, width;
    private double[][] table;

    public SimplexTable(int height, int width) {
        this.height = height;
        this.width = width;
        table = new double[height][];
        for (double[] doubles : table) {
            doubles = new double[width];
        }
    }

    public SimplexTable(int height, int width, double[][] table) {
        this.height = height;
        this.width = width;
        this.table = table;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double[][] getTable() {
        return table;
    }

    public void setTable(double[][] table) {
        this.table = table;
    }

    public double getIthJthElement(int i, int j) {
        return table[i][j];
    }

    public void setIthJthElenebt(int i, int j, double x) {
        table[i][j] = x;
    }
}
