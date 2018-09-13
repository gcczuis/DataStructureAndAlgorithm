package dataStructure.linkedlist;

public class LinkedListStack<E> implements Stack<E>{
    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }


    @Override
    public void push(E element) {
        linkedList.addFirst(element);

    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: Top ");
        res.append(linkedList);
        return res.toString();
    }

    public static void main(String[] args){
        LinkedListStack linkedListStack = new LinkedListStack();
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
            System.out.println(linkedListStack);
        }
        linkedListStack.pop();
        System.out.println(linkedListStack);
    }
}
