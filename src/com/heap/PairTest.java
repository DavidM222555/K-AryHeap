package com.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void getFirst() {
        Pair<Integer, Integer> testPair = new Pair<>(33, 33);

        assert(testPair.getFirst().equals(33));
    }

    @Test
    void getSecond() {
        Pair<Integer, Integer> testPair = new Pair<>(33, 33);

        assert(testPair.getSecond().equals(33));
    }

    @Test
    void testEquals() {
        Pair<Integer, Integer> pair1 = new Pair<>(33, 33);
        Pair<Integer, Integer> pair2 = new Pair<>(33, 33);
        Pair<Integer, Integer> pair3 = new Pair<>(33, 55);
        Pair<Integer, String> pair4 = new Pair<>(33, "55");

        assert(pair1.equals(pair2));
        assert(pair1.equals(pair3));
        assert(pair4.equals(pair1));
    }
}