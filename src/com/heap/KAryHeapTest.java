package com.heap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


class KAryHeapTest {

    @Test
    void top() {
        Random rand = new Random();

        List<Integer> randomNums = new ArrayList<>();

        // Make sure that all the k-ary heaps get the same random elements
        for (int i = 0; i <= 25000; i++) {
            randomNums.add(rand.nextInt());
        }

        // Test for various values of k for our k-ary heap
        for (int i = 1; i <= 10; i++) {
            long startTime = System.nanoTime();

            KAryHeap<Integer, Integer> heap = new KAryHeap<>(i);

            // Insert a thousand random numbers into the heap
            for (int j = 0; j <= 25000; j++) {
                heap.insert(j, randomNums.get(j));
            }

            // Test that all top elements are correctly gathered
            for (int j = 0; j <= 25000; j++) {
                var topHeapElement = heap.peek();

                assert topHeapElement.isEmpty() || (elementHasTheMaxValue(heap.entries, topHeapElement.get()));

                // Remove the top element from the heap
                heap.top();
            }

            long endTime = System.nanoTime();

            System.out.println("Completed the k-ary heap top() test for k = " + i + " in " + (endTime - startTime));
        }
    }

    /**
     * Helper function utilized for finding out whether the current top element from the heap is equal
     * to one of the heap values with the largest priority.
     * @param heapEntries Entries currently in the heap
     * @param heapTopValue Value gathered from calling top() on heap
     * @return Whether the value gotten from heap.top() is equal to one of the values with the highest priority
     */
    boolean elementHasTheMaxValue(List<HeapEntry<Integer,Integer>> heapEntries, Integer heapTopValue) {
        List<Integer> elementsWithMaxValue = new ArrayList<>();
        Integer currentMaxValue = Integer.MIN_VALUE;

        for (var entry : heapEntries) {
            if (entry.getPriority() > currentMaxValue) {
                elementsWithMaxValue.clear();
                currentMaxValue = entry.getPriority();
                elementsWithMaxValue.add(entry.getEntry());
            }
            else if (Objects.equals(entry.getPriority(), currentMaxValue)) {
                elementsWithMaxValue.add(entry.getEntry());
            }
        }

        return elementsWithMaxValue.contains(heapTopValue);
    }


    @Test
    void insert() {
    }


    @Test
    void size() {
        KAryHeap<Integer, Integer> heap = new KAryHeap<>(2);

        for (int i = 0; i < 10; i++) {
            heap.insert(i, i);
        }

        assert(heap.size() == 10);
    }

    @Test
    void update() {
    }
}