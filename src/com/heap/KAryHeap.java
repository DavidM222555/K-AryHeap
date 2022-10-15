package com.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class KAryHeap <T, U extends Comparable<U>> implements Heap<T, U> {
    List<HeapEntry<T, U>> entries;
    int branchFactor;

    public KAryHeap(int branchFactor) {
        entries = new ArrayList<>();
        this.branchFactor = branchFactor;
    }

    @Override
    public Optional<T> top() {
        if (this.entries.size() == 0) {
            return Optional.empty();
        }

        var lastElement = removeLast();

        if (entries.size() == 0) {
            return Optional.of(lastElement.getEntry());
        }
        else {
            var topEntry = entries.get(0);
            entries.set(0, lastElement);
            pushDown(0);

            return Optional.of(topEntry.getEntry());
        }
    }

    @Override
    public Optional<T> peek() {
        if (this.entries.size() == 0) {
            return Optional.empty();
        }

        return Optional.of(entries.get(0).getEntry());
    }

    public void printEntries() {
        for (int i = 0; i < entries.size(); i++) {
            System.out.println(entries.get(i).getEntry());
        }
    }

    @Override
    public void insert(T element, U priority) {
        HeapEntry<T, U> he = new HeapEntry<>(element, priority);
        entries.add(he);
        bubbleUp(entries.size() - 1);
    }


    public int size() {
        return entries.size();
    }

    @Override
    public void update(T element, U newPriority) {
        int index = findElement(element);

        // We return -1 if the item isn't found in the heap
        if (index >= 0) {
            var oldPriority = entries.get(index).getPriority();
            var newPair = new HeapEntry<>(element, newPriority);
            entries.set(index, newPair);

            if (newPriority.compareTo(oldPriority) > 0) {
                bubbleUp(index);
            }
            else {
                pushDown(index);
            }
        }
    }

    private int findElement(T elementToDelete) {
        for (int i = 0; i < entries.size(); i++) {
            if (entries.get(i).getEntry().equals(elementToDelete)) {
                return i;
            }
        }

        return -1;
    }

    private HeapEntry<T, U> removeLast() {
        var lastEntry = entries.get(entries.size() - 1);
        entries.remove(entries.size() - 1);

        return lastEntry;
    }

    private int getParentIndex(int index) {
        return (index - 1) / branchFactor;
    }

    private boolean isLeaf(int index) {
        return index >= (entries.size() - 2) / branchFactor + 1;
    }

    private Pair<HeapEntry<T,U>,Integer> getHighestPriorityChild(int index) {
        HeapEntry<T,U> maxPriority = null;
        int maxIndex = -1;

        for (int i = 1; i <= branchFactor; i++) {
            int currentIndex = branchFactor * index + i;

            if (currentIndex < entries.size()) {
                if (maxPriority == null) {
                    maxPriority = entries.get(currentIndex);
                    maxIndex = currentIndex;
                }

                if (entries.get(currentIndex).getPriority().compareTo(maxPriority.getPriority()) > 0) {
                    maxPriority = entries.get(currentIndex);
                    maxIndex = currentIndex;
                }
            }
        }

        return new Pair<>(maxPriority, maxIndex);
    }

    private void pushDown(int index) {
        int currentIndex = index;

        while (!isLeaf(currentIndex) && (entries.size() != 1)) {
            var highestPriorityChild = getHighestPriorityChild(currentIndex);
            var highestPriorityChildEntry = highestPriorityChild.getFirst();
            var highestPriorityChildIndex = highestPriorityChild.getSecond();

            if (highestPriorityChildEntry.getPriority().compareTo(entries.get(currentIndex).getPriority()) > 0) {
                Collections.swap(entries, currentIndex, highestPriorityChildIndex);
                currentIndex = highestPriorityChildIndex;
            }
            else {
                break;
            }
        }
    }

    private void bubbleUp(int index) {
        int parentIndex = entries.size() - 1;

        while (parentIndex > 0) {
            int currentIndex = parentIndex;
            parentIndex = getParentIndex(parentIndex);

            if (entries.get(currentIndex).getPriority().compareTo(entries.get(parentIndex).getPriority()) > 0) {
                Collections.swap(entries, currentIndex, parentIndex);
            }
            else {
                break;
            }
        }
    }

}