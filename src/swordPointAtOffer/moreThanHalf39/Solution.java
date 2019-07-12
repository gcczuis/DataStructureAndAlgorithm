package swordPointAtOffer.moreThanHalf39;

import java.util.HashMap;

/**
 * {@author: gcc}
 * {@Date: 2019/7/2 17:13}
 */
public class Solution {

    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int key = array[i];
            if (map.containsKey(key)) {
                Integer value = map.get(key);
                map.put(key, value + 1);
                if (value + 1 > length / 2) {
                    return key;
                }
            } else {
                //如果只有一个元素的话，就直接返回
                if (1 > length / 2) {
                    return key;
                }
                map.put(key, 1);
            }
        }
        return 0;
    }
}
