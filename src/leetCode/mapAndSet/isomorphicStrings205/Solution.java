package leetCode.mapAndSet.isomorphicStrings205;

import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character d = t.charAt(i);
            if(map2.containsKey(c)){
                if(map2.get(c).equals(d)) continue;
                else return false;
            }
            if(map1.containsKey(d)){
                if(map1.get(d).equals(c)) continue;
                else return false;
            }
            if(!map1.containsKey(d) && !map2.containsKey(c)){
                map1.put(d,c);
                map2.put(c,d);
            }
        }
        return true;
    }
}


