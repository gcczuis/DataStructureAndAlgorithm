package leetCode.mapAndSet.groupAnagrams49;

import java.util.*;

/**
 * {@author: gcc}
 * {@Date: 2019/5/24 10:05}
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) return result;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortedS = new String(c);
            if (!map.containsKey(sortedS)) {
                map.put(sortedS, new ArrayList<String>());
            }
            map.get(sortedS).add(str);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 1) {
                result.add(entry.getValue());
            }
        }

        return result;
    }
}
