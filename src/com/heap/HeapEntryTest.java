package com.heap;

import static org.junit.jupiter.api.Assertions.*;

class HeapEntryTest {

    @org.junit.jupiter.api.BeforeEach
    void init() {
    }

    @org.junit.jupiter.api.Test
    void getEntry() {
        HeapEntry<String, Integer> he = new HeapEntry<>("Priority 1", 33);

        assert(he.getEntry().equals("Priority 1"));
    }

    @org.junit.jupiter.api.Test
    void getPriority() {
        HeapEntry<String, Integer> he = new HeapEntry<>("Priority 1", 10);

        assert(he.getPriority().equals(10));
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        HeapEntry<String, Integer> he1 = new HeapEntry<>("Priority 1", 10);
        HeapEntry<String, Integer> he2 = new HeapEntry<>("Priority 1", 10);
        HeapEntry<Integer, Integer> he3 = new HeapEntry<>(33, 33);

        assert(he1.equals(he2));
        assert(!he1.equals(he3));
    }
}