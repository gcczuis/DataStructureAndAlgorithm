package dataStructure.linkedlist;

public class LinkedList <E>{
    //由于Node内部类只在链表内部使用不希望被外部调用，所以设计为private
    private class Node{
        //为了方便设定值，设定为public就不再需要繁琐的set，get方法了
        public E element;
        public Node next;
        public Node(E element,Node next){
            this.element = element;
            this.next = next;
        }
        public Node(E element){
            this(element,null);
        }
        public Node(Node next){
            this(null,next);
        }

        @Override
        public String toString(){
            return element.toString();
        }
    }

    private int size;
    //设置一个虚拟头结点，方便下面各种方法的逻辑编写
    private Node dummyHead;

    public LinkedList(){
        //由于链表不像数组，是个动态数据结构，所以一开始的size为0
        size = 0;
        dummyHead = new Node(null,null);
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E element){
        if(index < 0 || index > size)
            throw new IllegalArgumentException("add failed, index < 0 || index >= size");
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(element,pre.next);
        size ++;
    }

    public void addFirst(E element){
        add(0,element);
    }

    public void addLast(E element){
        add(size,element);
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("add failed, index < 0 || index >= size");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    public boolean contains(E element){
        Node cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            E curElement = cur.element;
            if(curElement.equals(element))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("add failed, index < 0 || index >= size");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.element;
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeFirst(){
        return remove(0);
    }

    //在链表中删除指定元素
    public void removeElement(E e){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.element.equals(e))
                break;
            prev = prev.next;
        }
        if(prev.next != null){

            Node toRemove = prev.next;
            prev.next = toRemove.next;
            toRemove.next = null;
            size --;
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur.next != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append(cur + "->NULL");
        return res.toString();
    }

    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2,666);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);

    }


}
