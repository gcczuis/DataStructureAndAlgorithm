package leetCode.mapAndSet.sortCharactersByFrequency451;


import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    private class Node implements Comparable<Node> {
        public char c;
        public int freq;

        public Node(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Node o) {
            return o.freq - this.freq;//反序，因为最大的排前面
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
        PriorityQueue<Node> queue = new PriorityQueue<>();
        map.entrySet().forEach(entry-> queue.add(new Node(entry.getKey(),entry.getValue())));
        StringBuilder ret = new StringBuilder();
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            for (int j = 0; j < n.freq; j++) {
                ret.append(n.c);
            }
        }
        return ret.toString();
    }
}
