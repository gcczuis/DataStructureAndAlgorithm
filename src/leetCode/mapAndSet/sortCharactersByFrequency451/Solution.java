package leetCode.mapAndSet.sortCharactersByFrequency451;

import dataStructure.maxheap.MaxHeap;

import java.util.HashMap;

public class Solution {
    private class Node implements  Comparable<Node> {
        public char c;
        public int freq;

        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq - o.freq;
        }
    }

    public String frequencySort(String s) {
        char[] array = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            if(map.containsKey(c)) map.put(c,map.get(c) + 1);
            else map.put(c, 1);
        }
        MaxHeap<Node> maxHeap = new MaxHeap();
        for (char c: map.keySet()) {
            maxHeap.add(new Node(c,map.get(c)));
        }
        StringBuilder ret = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Node n = maxHeap.extractMax();
            for (int j = 0; j < n.freq; j++) {
                ret.append(n.c);
            }
        }
        return ret.toString();

    }

}
