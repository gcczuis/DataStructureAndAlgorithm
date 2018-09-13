package leetCode.slidingWindow.minimumWindowSubstring76;

import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        String ret = "";
        int length = Integer.MAX_VALUE;
        if(t.length() > s.length()) return ret;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c: t.toCharArray()) {
            map.put(c,map.getOrDefault(c, 0) + 1);
        }
        int start = 0, end = 0, counter = map.size();
        while (end < s.length()){
            Character c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) counter -- ;
            }
            end ++;
            while(counter == 0){
                Character sc = s.charAt(start);
                if(map.containsKey(sc)){
                    map.put(sc,map.get(sc) + 1);
                    if(map.get(sc) > 0) counter ++;

                }
                if(length > end - start) {
                    length = end -start;
                    ret = s.substring(start, end);
                }
                start ++;
            }
        }
        return ret;
    }
   /*public static void main(String[] args){
        String s = "ADOBECODEBANC";
        minWindow(s, "ABC");
    }*/

}
