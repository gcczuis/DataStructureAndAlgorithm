package leetCode.collisionPointer.reverseString344;

public class Solution2 {
    //指针碰撞
    public String reverseString(String s) {
        if(null == s || s.isEmpty()) return s;
        char[] ret = s.toCharArray();
        for(int i=0, j = s.length() -1; i<j; i++, j--){
            char ch = ret[i];
            ret[i] = ret[j];
            ret[j] = ch;
        }
        return new String(ret);
    }
}
