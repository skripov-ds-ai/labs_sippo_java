package com.examples.skripov.sippo.lesson2.solver.simplex_table.bimap;

import java.util.HashMap;
import java.util.Map;

public final class BiMap<T, M> {
    private Map<T, M> t2m;
    private Map<M, T> m2t;

    public BiMap() {
        t2m = new HashMap<>();
        m2t = new HashMap<>();
    }

    public final void add(T t, M m) {
        t2m.put(t, m);
        m2t.put(m, t);
    }

    public final T getT(M m) {
        return m2t.get(m);
    }

    public final M getM(T t) {
        return t2m.get(t);
    }

    public final void removeT(T t) {
        M m = t2m.remove(t);
        m2t.remove(m);
    }

    public final void removeM(M m) {
        T t = m2t.remove(m);
        t2m.remove(t);
    }

    @Override
    public String toString() {
        return "BiMap{" +
                "t2m=" + t2m +
                ", m2t=" + m2t +
                '}';
    }
}
