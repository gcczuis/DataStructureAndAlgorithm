package dataStructure.maxheap;


public class Array<E> {
    private E[] data;
    private int size;
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(E[] arr){
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }    
    }

    public Array(){
        this(10);
    }

    public void add(int index,E element){
        if(index > size || index < 0)
            throw new IllegalArgumentException("add failed,index > size || index < 0");
        if(size == data.length)
            resize(size * 2);
        for(int i = size;i > index;i--){
            data[i] = data[i-1];
        }
        data[index] = element;
        size++;
    }

    public void addFirst(E element){
        add(0,element);
    }

    public void addLast(E element){
        add(size,element);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean contains(E element){
        return find(element) != -1;
    }

    /**
     * 查找某个元素在数组中第一个出现的位置，若不存在则返回-1
     * @param element
     * @return
     */
    public int find(E element){
        for (int i = 0; i < size; i++) {
            if(element.equals(data[i]))
                return i;
        }
        return -1;
    }

    public void swap(int index1, int index2){
        if(index1 < 0 || index1 >= size || index2 < 0 || index2 >= size)
            throw new IllegalArgumentException("index is illegal");


        E e = data[index1];
        data[index1] = data[index2];
        data[index2] = e;
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index < 0 || index >= size");
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    public E remove(int index){
        E ret = data[index];
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("remove failed,index < 0 || index >= size");
        if(size == data.length/4 && data.length != 1)
            resize(data.length / 2);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size-1] = null;
        size --;
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public void removeElement(E element){
        int index = find(element);
        if(index != -1){
            remove(index);
        }
    }

    public void set(int index, E element){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("set failed,index < 0 || index >= size");
        data[index] = element;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;

    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0 ; i < size-1 ; i++){
            res.append(data[i]+",");
        }
        res.append(data[size-1]+"]");
        return res.toString();
    }
}
