package dataStructure.UF;

/**
 * 第六版并查集，路径压缩，将所有树压缩成高度为2的树，第一行是根节点，第二行是集合中所有其他节点
 * 数组结构和树结构，数组索引为要查的数，数组内容为父节点索引，一直追溯向上，直到父节点为本身，则此节点为集合编号
 */
public class UnionFind6 implements UF{

    private int[] parent;

    private int[] rank; //rank[i]表示以i为根的集合所表示的树的层数

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            //初始化时每个元素的索引（即要查的数）为集合编号，各不相同
            parent[i] = i;
            //每个元素自己独立成为一个集合，高度为1
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查看元素p和元素q是否所属同一集合,时间复杂度O(h)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合,将元素个数少的集合合并到元素个数多的集合中去
    // 时间复杂度O(h),h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = parent[p];
        int qRoot = parent[q];
        if(pRoot == qRoot)
            return ;
        if(rank[pRoot] < rank[qRoot])
            parent[pRoot] = find(qRoot);

        else if(rank[pRoot] > rank[qRoot])
            parent[qRoot] = find(pRoot);
        else {//rank[pRoot] = rank[qRoot
            parent[pRoot] = find(pRoot);
            rank[pRoot] ++;
        }
    }

    //查找元素p所对应的集合编号
    //路径压缩,使用了递归函数使得节点p及他的父亲节点都指向根节点
    // 时间复杂度O(h),h为树的高度
    private int find(int p){
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p < 0 || p >= id.length");
        if(p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
}
