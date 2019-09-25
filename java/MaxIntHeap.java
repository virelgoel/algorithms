/*
 * Copyright 2019, FMR LLC.
 * All Rights Reserved
 * Fidelity Confidential Information
 */

import java.util.Arrays;

public class MaxIntHeap {
    private int capacity = 10;
    private int size = 0;

    public int[] items = new int[capacity];

    private int leftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }


    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return parentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int parent(int index) {
        return items[parentIndex(index)];
    }

    public void print() {
        for (int i=0; i < size; i++) {
            System.out.println(i + "[" + items[i] + "]" );
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureCapactity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void heapifyUp() {
        int index = size - 1; //start at the last element

        //while parent is less
        while (hasParent(index) && parent(index) < items[index]) {
            swap(parentIndex(index), index);
            index = parentIndex(index); //go to the parent
        }
    }

    private void heapifyDown() {
        int index = 0; //start at top

        // as long as I have children
        // note: Only need to check left because if no left, there is no right
        while (hasLeftChild(index)) {
            // take the larger of the left and right child indexes
            int largerChildIndex = leftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChild(index)) {
                largerChildIndex = rightChildIndex(index);
            }

            //compare
            // if I am larger than the largest of my children...
            // then everything is good. I am sorted.
            if(items[index] > items[largerChildIndex]) {
                break;
            } else {
                //  we are still not in order - swap
                swap(index, largerChildIndex);
            }

            //move down to the child
            index = largerChildIndex;
        }
    }

    public void insert(int item) {
        ensureCapactity();
        items[size] = item; //insert in last spot
        size++;
        heapifyUp();
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0]; // grab the max
        items[0] = items[size - 1]; // move the bottom to the max
        size--; //inherently deletes the bottom element
        heapifyDown();
        return item;    //return the element

    }
}
