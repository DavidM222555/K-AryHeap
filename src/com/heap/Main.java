package com.heap;

public class Main {

    public static void main(String[] args) {
        KAryHeap<String, Integer> heap = new KAryHeap<>(2);

        heap.insert("Priority 3", 3);
        heap.insert("Priority 5", 5);
        heap.insert("Priority 1", 1);
        heap.insert("Priority 7", 7);

        var firstPriority = heap.top();
        var secondPriority = heap.top();
        var thirdPriority = heap.top();

        heap.insert("Priority 9", 9);
        heap.update("Priority 1", 88);
        var fourthProperty = heap.top();

        System.out.println(heap.size());

        if (firstPriority.isPresent()) {
            System.out.println(fourthProperty.get());
        }

    }
}
