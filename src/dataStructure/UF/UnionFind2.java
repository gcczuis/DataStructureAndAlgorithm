package dataStructure.UF;

/**
 * 第二版并查集
 * 数组结构和树结构，数组索引为要查的数，数组内容为父节点索引，一直追溯向上，直到父节点为本身，则此节点为集合编号
 */
public class UnionFind2 implements UF{

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            //初始化时每个元素的索引（即要查的数）为集合编号，各不相同
            parent[i] = i;
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

    //合并元素p和元素q所属的集合
    // 时间复杂度O(h),h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = parent[p];
        int qRoot = parent[q];
        if(pRoot == qRoot)
            return ;
        parent[find(p)] = find(q);
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
