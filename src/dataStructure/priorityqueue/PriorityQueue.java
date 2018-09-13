package dataStructure.priorityqueue;

import dataStructure.maxheap.MaxHeap;

public class PriorityQueue<E extends Comparable> implements Queue<E>{

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap();
    }


    @Override
    public void enqueue(E element) {
        maxHeap.add(element);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
