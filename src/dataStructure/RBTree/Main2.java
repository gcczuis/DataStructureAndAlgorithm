package dataStructure.RBTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * 2000万随机数的添加。
 * BST: 41.384668292 s 由于是随机数，所以二分搜索树的平均性能也是O(logn)的
 * AVL: 40.190289703 s
 * dataStructure.RBTree: 37.437433506 s 在添加数据这个操作中由于旋转操作比avl少所以性能更优
 */
public class Main2 {

    public static void main(String[] args) {

        // int n = 20000000;
        int n = 20000000;

        Random random = new Random(n);
        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            testData.add(random.nextInt(Integer.MAX_VALUE));

        // Test BST
        long startTime = System.nanoTime();

        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        for (Integer x: testData)
            bst.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("BST: " + time + " s");


        // Test AVL
        startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<Integer, Integer>();
        for (Integer x: testData)
            avl.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("AVL: " + time + " s");


        // Test dataStructure.RBTree
        startTime = System.nanoTime();

        RBTree<Integer, Integer> rbt = new RBTree<Integer, Integer>();
        for (Integer x: testData)
            rbt.add(x, null);

        endTime = System.nanoTime();

        time = (endTime - startTime) / 1000000000.0;
        System.out.println("dataStructure.RBTree: " + time + " s");
    }
}
