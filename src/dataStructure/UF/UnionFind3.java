package dataStructure.UF;

/**
 * 第三版并查集，基于size的优化，在合并p集合和q集合时，先计算两棵树的size(集合中元素数量)，将size小的合并到size大的树中
 * 数组结构和树结构，数组索引为要查的数，数组内容为父节点索引，一直追溯向上，直到父节点为本身，则此节点为集合编号
 */
public class UnionFind3 implements UF{

    private int[] parent;

    private int[] sz; //sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            //初始化时每个元素的索引（即要查的数）为集合编号，各不相同
            parent[i] = i;
            //每个元素自己独立成为一个集合
            sz[i] = 1;
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
        if(sz[pRoot] < sz[qRoot]){
            parent[pRoot] = find(qRoot);
            sz[qRoot] += sz[pRoot];
        }
        else
            parent[qRoot] = find(pRoot);
            sz[pRoot] += sz[qRoot];
    }

    //查找元素p所对应的集合编号
    // 时间复杂度O(h),h为树的高度
    private int find(int p){
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p < 0 || p >= id.length");
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }
}
