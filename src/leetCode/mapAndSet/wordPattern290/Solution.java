package leetCode.mapAndSet.wordPattern290;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String s = strs[i];
            if(map2.containsKey(c)){
                if(map2.get(c).equals(s)) continue;
                else return false;
            }
            if(map1.containsKey(s)){
                if(map1.get(s).equals(c)) continue;
                else return false;
            }
            if(!map1.containsKey(s) && !map2.containsKey(c)){
                map1.put(s,c);
                map2.put(c,s);
            }
        }
        return true;

    }
}