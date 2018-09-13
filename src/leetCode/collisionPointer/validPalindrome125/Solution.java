package leetCode.collisionPointer.validPalindrome125;

class Solution {
    //注意：验证的回文字是指大写字母小写字母以及数字
    public boolean isPalindrome(String s) {
        if(s.equals("")) return true;
        //指针对撞，设定左右两个指针
        int l = 0, r = s.length() - 1;
        while(l < r){
            Character lc = s.charAt(l);
            Character rc = s.charAt(r);
            if(! Character.isLetterOrDigit(lc)) l++;
            else if(! Character.isLetterOrDigit(rc)) r--;
            else if(Character.toLowerCase(lc) == Character.toLowerCase(rc)){
                l++;
                r--;
            }
            else return false;
        }
        return true;
    }
}