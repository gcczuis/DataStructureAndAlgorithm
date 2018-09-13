package dataStructure.queue;



public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    //由于这里的data前后有空位所以不能单纯的用data.getSize来获得结果，需要自己维护size
    private int size;

    public LoopQueue(){
        this(5);

    }
    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(E element) {
        //如果循环队列已满
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = element;

        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E dequeue() {
        if(size == data.length/4){
            resize(data.length/2);
        }
        if(isEmpty())
            throw new RuntimeException("dequeue failed,the queue is empty");
        E res = data[front];
        data[front] = null;
        front = (front+1) % data.length;
        size --;
        return res;

    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    //由于在data数组中会有意识的留出一个空位
    public int getCapacity(){
        return data.length - 1;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue:size=%d,capacity=%d\n",size,getCapacity()));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(front + i) % data.length]);
            if(i != size-1) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args){
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
    }

}
