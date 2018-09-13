package dataStructure.trie;

import java.util.TreeMap;

public class Trie {

    private class Node{
        public boolean isWord;
        public TreeMap<Character, Node> next;
        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }

    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    //获得Trie中的单词数量
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //向Trie中添加一个单词word
    public void add(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if(cur.next.get(character) == null){
                cur.next.put(character, new Node());
            }
            cur = cur.next.get(character);
        }
        if(cur.isWord == false){
            cur.isWord = true;
            size ++;
        }
    }

    //查询单词word是否在Trie中
    public boolean contains(String word){
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            Character character = word.charAt(i);
            if(cur.next.get(character) == null){
                return false;
            }
            cur = cur.next.get(character);
        }
        return cur.isWord;
    }

    //查询在Trie中是否有以此prefix为前缀的单词
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character character = prefix.charAt(i);
            if(cur.next.get(character) == null){
                return false;
            }
            cur = cur.next.get(character);
        }
        return true;
    }




}
