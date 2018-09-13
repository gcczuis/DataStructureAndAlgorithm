package dataStructure.stack;

import dataStructure.array.Array;

public class ArrayStack<E> implements Stack<E>{
    private Array<E> array;
    ArrayStack(){
        array = new Array<>();
    }
    ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    @Override
    public void push(E element) {
        array.addLast(element);
    }

    @Override
    public E pop() {
        E last = array.removeLast();
        return last;

    }

    @Override
    public E peek() {
        E last = array.getLast();
        return last;
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(",");
            }
        }
        res.append("]TOP");
        return res.toString();
    }
}
