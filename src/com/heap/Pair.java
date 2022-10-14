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
}
