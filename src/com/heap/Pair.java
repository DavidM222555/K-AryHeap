package com.heap;

public class Pair<K,V> {
    K item1;
    V item2;

    public Pair(K item1, V item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public K getFirst() {
        return item1;
    }
    public V getSecond() {
        return item2;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair objectAsPair)) {
            return false;
        }

        if (objectAsPair.getFirst() != this.getFirst() || objectAsPair.getSecond() != this.getSecond()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return item1.hashCode() + item2.hashCode();
    }
}
