package dataStructure.priorityqueue;

public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
