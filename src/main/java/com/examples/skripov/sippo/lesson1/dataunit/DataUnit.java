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
}
