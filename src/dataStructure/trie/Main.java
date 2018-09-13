package dataStructure.trie;

import dataStructure.set.FileOperation;
import dataStructure.set.LinkedListSet;

import java.util.ArrayList;

//通过使用底层为二叉树和链表构成的set来统计两本书的生词个数
public class Main {
    public static void main(String[] args){
        System.out.println("===============BSTSet==============================");
        System.out.println("Pride and Prejudice");


        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("files\\pride-and-prejudice.txt",words1);
        System.out.println("Total words:" +words1.size());
        BSTSet<String> set1 = new BSTSet<>();
        long startTime = System.nanoTime();
        for(String word : words1){
            set1.add(word);
        }
        for(String word4 : words1){
            set1.contains(word4);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("total different words:" + set1.getSize());

        System.out.println("BSTSet:" + time + "s");


        //===============linkedListSet==============================
        System.out.println("===============trie==============================");

        System.out.println("Pride and Prejudice");

        ArrayList<String> words5 = new ArrayList<>();
        FileOperation.readFile("files\\pride-and-prejudice.txt",words5);
        System.out.println("Total words:" +words5.size());
        BSTSet<String> set2 = new BSTSet<>();
        startTime = System.nanoTime();
        for(String word : words1){
            set2.add(word);
        }
        for(String word5 : words1){
            set2.contains(word5);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("total different words:" + set2.getSize());

        System.out.println("BSTSet:" + time + "s");
    }
}
