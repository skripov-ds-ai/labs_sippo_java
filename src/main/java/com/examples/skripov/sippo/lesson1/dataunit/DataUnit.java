package com.examples.skripov.sippo.lesson1.dataunit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class DataUnit implements Externalizable {
    private int iterations;
    private double a, b, epsilon;
    private boolean minimum;

    public DataUnit() {
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(double epsilon) {
        this.epsilon = epsilon;
    }

    public boolean isMinimum() {
        return minimum;
    }

    public void setMinimum(boolean minimum) {
        this.minimum = minimum;
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(iterations);
        objectOutput.writeDouble(a);
        objectOutput.writeDouble(b);
        objectOutput.writeDouble(epsilon);
        objectOutput.writeBoolean(minimum);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        iterations = objectInput.readInt();
        a = objectInput.readDouble();
        b = objectInput.readDouble();
        epsilon = objectInput.readDouble();
        minimum = objectInput.readBoolean();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataUnit dataUnit = (DataUnit) o;

        if (iterations != dataUnit.iterations) return false;
        if (Double.compare(dataUnit.a, a) != 0) return false;
        if (Double.compare(dataUnit.b, b) != 0) return false;
        if (Double.compare(dataUnit.epsilon, epsilon) != 0) return false;
        return minimum == dataUnit.minimum;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iterations;
        temp = Double.doubleToLongBits(a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(epsilon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (minimum ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DataUnit{" +
                "iterations=" + iterations +
                ", a=" + a +
                ", b=" + b +
                ", epsilon=" + epsilon +
                ", minimum=" + minimum +
                '}';
    }
}
