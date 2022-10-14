package com.heap;

public class HeapEntry<T, U extends Comparable<U>> {
    private T entry;
    private U priority;

    public HeapEntry(T entry, U priority) {
        this.entry = entry;
        this.priority = priority;
    }

    public T getEntry() {
        return entry;
    }

    public U getPriority() {
        return priority;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HeapEntry<?,?>)) {
            return false;
        }

        var heapEntry = (HeapEntry) o;

        if (heapEntry.getPriority() != this.getPriority() || heapEntry.getEntry() != this.getEntry()) {
            return false;
        }

        return true;
    }
}
