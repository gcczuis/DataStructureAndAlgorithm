package dataStructure.trie;

import dataStructure.binarysearchtree.BST;
import dataStructure.set.LinkedListSet;
import dataStructure.set.Set;

public class BSTSet<E extends Comparable> implements Set<E> {

    private BST bst;

    public BSTSet(){
        bst = new BST();
    }

    @Override
    public void add(E element) {
        bst.add(element);
    }

    @Override
    public void remove(E element) {
        bst.remove(element);
    }

    @Override
    public boolean contains(E element) {
        return bst.contains(element);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.getSize() == 0;
    }

    public static void main(String[] args){
        LinkedListSet<String> set = new LinkedListSet<>();
        set.add("11");
        set.add("12");
        set.add("11");
        set.add("13");
        System.out.println(set.getSize());
    }

}
