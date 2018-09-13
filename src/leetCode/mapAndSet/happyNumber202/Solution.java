package leetCode.mapAndSet.happyNumber202;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(true){
            n = timeAndAdd(n);
            if(n == 1) return true;
            else if(set.contains(n)) return false;
            else set.add(n);
        }
    }
    private int timeAndAdd(int a){
        ArrayList<Integer> list = new ArrayList();
        while(a != 0){
            list.add(a % 10);
            a/=10;
        }
        int ret = 0;
        for (Integer i: list) {
            ret = ret + i * i;
        }
        return ret;
    }

}
