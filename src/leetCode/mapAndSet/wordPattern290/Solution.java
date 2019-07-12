package leetCode.mapAndSet.wordPattern290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static boolean wordPattern(String pattern, String str) {
        char[] patterns = pattern.toCharArray();
        Map<Character,String> maps = new HashMap<>();
        String[] strs = str.split(" ");

        if(patterns.length != strs.length)
            return false;

        for(int i = 0;i<patterns.length;i++){
            char ch = patterns[i];
            if(maps.containsKey(ch)){
                String value = maps.get(ch);
                if(!value.equals(strs[i]))
                    return false;
            }else{
                if(maps.containsValue(strs[i]))
                    return false;
                maps.put(ch,strs[i]);
            }
        }
        return true;























        /*Solution[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false;
        HashMap<Solution, Character> map1 = new HashMap<>();
        HashMap<Character, Solution> map2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            Solution s = strs[i];
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
        return true;*/

    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}