package dataStructure.segmentTree;


public class SegmentTree<E> {

    //深刻理解下面这两个数组的索引的含义对于理解线段树非常重要。

    //tree数组是用来存储节点的
    private E[] tree;
    //data数组是用来存储用户传来的固定的数据，也就是相当于tree的非空叶子节点
    private E[] data;

    //数据融合器，定义了在线段树区间中做的事情
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger merger){

        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //由于一般情况下的线段树是一颗平衡二叉树，既不是完全二叉树（叶子节点从左到右排列），也不是一颗满二叉树。为了计算左子节点和
        // 右子节点的方便，所以要构建一颗满二叉树，空节点位置放null，所以在最坏情况下要浪费整颗二叉树一半的空间。经过计算需要4倍
        //arr.length空间（有少许浪费）
        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //在treeIndex的位置创建表示区间【l...r】的线段树
    private void buildSegmentTree (int treeIndex, int l, int r){
        if(l == r) {
            tree[treeIndex] = data[l];
            return ;
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    //返回区间【queryL, queryR】的值
    public E query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length) throw new IllegalArgumentException("queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length");
        E ret = query(0, 0, data.length - 1, queryL, queryR);
        return ret;
    }

    //更新指定索引元素
    public void set(int index, E element){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("index < 0 || index >= data.length");
        data[index] = element;
        set(0, 0, data.length - 1, index, element);
    }

    private void set(int rootIndex, int l, int r, int index, E element){
        if(l == r && r == index){
            tree[rootIndex] = element;
            return;
        }
        int leftChild = leftChild(rootIndex);
        int rightChild = rightChild(rootIndex);
        int mid = l + (r - l) / 2;
        if(index <= mid)
            set(leftChild, l, mid, index, element);
        else
            set(rightChild, mid + 1, r, index, element);
        tree[rootIndex] = merger.merge(tree[leftChild],tree[rightChild]);
    }



    //在以treeIndex为根的线段树中【l...r】的范围里，搜索区间【queryL...queryR】的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        //终止条件
        if(l == queryL && r == queryR) return tree[treeIndex];

        int mid = l + (r -l) / 2;
        int leftChild = leftChild(treeIndex);
        int rightChild = rightChild(treeIndex);
        //三种情况的处理
        if(queryR <= mid) return query(leftChild, l, mid, queryL, queryR);
        else if(queryL >= mid + 1) return query(rightChild, mid + 1, r, queryL, queryR);
        else{
            return merger.merge(query(leftChild, l, mid, queryL, mid), query(rightChild, mid + 1, r, mid +1, queryR));
        }
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length) throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    //返回完全二叉树中节点的左子节点的索引
    public int leftChild(int index){
        return 2 * index + 1;
    }
    //返回完全二叉树中节点的右子节点的索引
    public int rightChild(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null)
                stringBuilder.append(tree[i]+" ");
            else
                stringBuilder.append("null"+" ");
            if(i == tree.length - 1)
                stringBuilder.append("]");
        }
        return stringBuilder.toString();
    }


}
