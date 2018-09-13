package dataStructure.RBTree;

import java.util.ArrayList;

/**
 * 2000万顺序数据插入
 * AVL: 10.041203342 s
 * dataStructure.RBTree: 9.47361364 s
 */
public class Main3 {

    public static void main(String[] args) {

        int n = 20000000;

        ArrayList<Integer> testData = new ArrayList<>(n);
        for(int i = 0 ; i < n ; i ++)
            testData.add(i);

        // Test AVL
        long startTime = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<Integer, Integer>();
        for (Integer x: testData)
            avl.add(x, null);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
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
