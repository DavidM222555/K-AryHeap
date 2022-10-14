package com.heap;

import java.util.Optional;

public interface Heap <T, U extends Comparable<U>> {
    Optional<T> top();
    Optional<T> peek();

    void insert(T element, U priority);
    void remove(T element);
    void update(T element, U newPriority);

}
