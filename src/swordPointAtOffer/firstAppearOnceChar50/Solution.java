package swordPointAtOffer.firstAppearOnceChar50;

import java.util.HashMap;
import java.util.Map;

/**
 * {@author: gcc}
 * {@Date: 2019/7/4 10:47}
 */
public class Solution {
    class Cc {
        int index;
        int freq = 1;

        public Cc(int index) {
            this.index = index;
        }

        Cc incre() {
            freq++;
            return this;
        }
    }

    public int FirstNotRepeatingChar(String str) {
        Map<Character, Cc> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c).incre());
            } else {
                map.put(c, new Cc(i));
            }
        }


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c).freq == 1) {
                return map.get(c).index;
            }
        }
        return -1;

    }
}
