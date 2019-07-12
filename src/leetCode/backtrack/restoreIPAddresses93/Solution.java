package leetCode.backtrack.restoreIPAddresses93;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * {@author: gcc}
 * {@Date: 2019/6/21 11:03}
 * 难,垃圾题（没做出来）
 */
public class Solution {
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        restoreIP(s, 0, "");
        return res;
    }

    //tempRes中保存了此时从str[0....index-1]翻译得到的一个ip串
    //从digits[index]开始寻找满足要求的且匹配str[0...index-1]的ip串
    private void restoreIP(String str, int index, String tempRes) {
        if (index > str.length()) {
            return;
        }
        if (index == str.length()) {
            System.out.println("xxx"+tempRes);
            res.add(tempRes);
            return;
        }
        //因为最多取三位数，所以最多循环三次
        for (int i = index; i < index + 3; i++) {
            if (i + 1 <= str.length()){

                String ip = str.substring(index, i + 1);
                if (makeSure(str, ip, tempRes, index)) {
                    if (tempRes.isEmpty()) {
                        restoreIP(str, i + 1, tempRes + ip);
                    } else {
                        restoreIP(str, i + 1, tempRes + "." + ip);
                    }
                }
            }
        }


    }

    private boolean makeSure(String str, String ip, String tempRes, int index) {
        int leftIp = 4 - tempRes.split(".").length + 1;
        int leftStrLength = str.length() - index;
        int ipp = Integer.parseInt(ip);
        return ipp <= 255 && ipp >= 0 && (leftStrLength <= (leftIp * 3) && leftStrLength >= leftIp) ? true : false;
    }


    @Test
    public void test() {
//        System.out.println("121".substring(1,3));
        List<String> list = restoreIpAddresses("25525511135");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
