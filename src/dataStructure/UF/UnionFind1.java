package dataStructure.UF;

/**
 * 第一版并查集
 * 纯数组结构，无树结构，数组索引为要查的数，数组内容为集合的编号
 */
public class UnionFind1 implements UF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            //初始化时每个元素的索引（即要查的数）为集合编号，各不相同
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查看元素p和元素q是否所属同一集合,时间复杂度O(1)
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并元素p和元素q所属的集合,时间复杂度O(n)
    @Override
    public void unionElements(int p, int q) {
        int qID = find(q);
        int pID = find(p);
        if(qID == pID)
            return ;
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pID)
                id[i] = qID;
        }
    }

    //查找元素p所对应的集合编号,时间复杂度O(1)
    private int find(int p){
        if(p < 0 || p >= id.length)
            throw new IllegalArgumentException("p < 0 || p >= id.length");
        return id[p];
    }
}
