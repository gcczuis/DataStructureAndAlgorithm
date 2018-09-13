package dataStructure.UF;

import java.util.Random;

public class Main {

    private static double testUF(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;


    }

    //在size = m = 100000的时候uf2表现的比uf1差，是因为
    //1：size和m相同时形成的树的高度很高
    //2：uf2中频繁用到find函数，而find函数是不断索引的过程，不是顺次访问一段连续的空间，所以速度慢一点，而uf1中合并操作是
    // 对一片连续的空间不停地做循环的操作，在jvm中有非常好的优化，所以运行速度会很快。
    //在对uf3进行了简单的优化之后，性能有了巨大的提升，说明了在uf2中树的高度非常高，近乎是个链表，所以uf2性能很差

    public static void main(String[] args){
        int size = 10000000;
        int m = 10000000;
/*        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("UnionFind1 : " + testUF(uf1, m) + "s");
        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2 : " + testUF(uf2, m) + "s");*/
        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUF(uf3, m) + "s");
        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUF(uf4, m) + "s");
        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUF(uf5, m) + "s");
        //第六版递归版（路径压缩加强版）比第五版性能反而差一点，是因为递归有开销。
        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind6 : " + testUF(uf6, m) + "s");
    }
}
