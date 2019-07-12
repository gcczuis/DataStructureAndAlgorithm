package dataStructure.maxheap;


//基于动态数组（自己实现的）的最大堆，索引从0开始，所以parentIndex = （childIndex-1）/2,leftChildIndex = parentIndex*2+1,rightChildIndex = parentIndex*2+2
public class MaxHeap<E extends Comparable> {

    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    //将一个未排序数组转化为一个最大堆数组，
    //思路：从不是叶子节点的最后一个节点开始进行siftdown操作
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    public void add(E element) {
        data.addLast(element);

        siftUp(data.getSize() - 1);

    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }


    //取出最大元素后，放入一个新元素
    //实现：可以先extractMax，再add，两次O(logn)的操作
    //实现：可以将最大元素替换为新元素，再对新元素进行siftdown操作，一次O(logn)的操作
    public E replace(E element) {
        E ret = data.get(0);
        data.set(0, element);
        siftDown(0);
        return ret;
    }

    public E findMax() {
        if (data.getSize() == 0) throw new IllegalArgumentException("the heap is empty");
        return data.getFirst();
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    //选择父节点两个孩子中较大的一个，如果比父节点还大，则这两节点交换位置
    private void siftDown(int index) {
        while (leftChild(index) < getSize()) {//肯定不是叶子节点
            int i = leftChild(index);
            if (i + 1 < getSize() && data.get(i).compareTo(data.get(i + 1)) < 0)
                i = rightChild(index);//i两个子节点中较大的那个的index
            if (data.get(i).compareTo(data.get(index)) > 0) {
                data.swap(i, index);
                index = i;
            } else
                break;
        }

    }


    private int parent(int childIndex) {
        //由于是私有方法，不会给客户调用，所以不会出现小于0的索引
        if (childIndex == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (childIndex - 1) / 2;
    }

    private int leftChild(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int rightChild(int parentIndex) {
        return parentIndex * 2 + 2;
    }


}
