package leetCode.slidingWindow.findAllAnagramsInAString438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        //假设s为“asvsuiwsll”而p为“sui”
        ArrayList<Integer> ret = new ArrayList<>();
        if(p.length() > s.length()) return ret;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i), 0) + 1);
        }
        //最重要的一点：正确理解counter含义
        int counter = map.size();
        int start = 0, end = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) counter --;
            }
            end ++;
            //进入循环在表示找到一个包含p的子串，在此题中子串为asvsui，进入循环让start的索引++观察是否能得到一个解
            while(counter == 0){
                char d = s.charAt(start);
                //找到一个结果
                if(end - start == p.length())
                    ret.add(start);
                if(map.containsKey(d)){
                    map.put(d, map.get(d) + 1);
                    if(map.get(d) > 0) counter ++;
                }
                start ++;
            }
        }
        return ret;
    }

   /* public static void main(String[] args){
        String s = "aa";
        findAnagrams(s,"bb");

    }*/
}


