package dataStructure.linkedlist;

import dataStructure.queue.Queue;

/**
 * 使用链表来实现队列，由于队列需要在一边增加元素，在另一边删除元素，而以前实现的队列在头部增加元素由于有head这个指针在
 * 时间复杂度为O(1)，而在尾部删除元素由于需要遍历整个链表所以时间复杂度为O(n)。所以需要作出如下改进：
 * 增加尾部指针tail。此时由于链表是单向链表，所以在链表头部增加和删除元素是O(1)，在链表尾部增加元素是O(1)，删除元素是O(n)，所以选择链表头部作为队列的尾（出队），链表尾部作为队列的头（入队）
 * 取消虚拟头结点，由于虚拟头结点的建立是为了解决在链表头部和链表中间的增加和删除操作逻辑不一致的问题，而队列是不需要处理中间数据的，所以不需要设虚拟头结点
 * 特殊情况：队列为空时，head = tail = null
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        Node node = new Node(element);
        if(tail == null && head == null){
            tail = node;
            head = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("dequeue failed, the queue is empty");
        E ret = head.e;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size --;
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("dequeue failed, the queue is empty");
        E ret = head.e;
        return ret;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder ret =  new StringBuilder();
        ret.append("Queue: front ");
        Node cur = head;
        while(cur != null) {
            ret.append(cur.e);
            ret.append("->");
            cur = cur.next;
        }
        ret.append("NULL");
        return ret.toString();

    }

    public static void main(String[] args){
        LinkedListQueue<Integer> linkedListQueue= new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if (i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }





}
