package leetCode.collisionPointer.ReverseVowelsOfAString345;


public class Solution {
    public  static String reverseVowels(String s) {
        if(s.equals("")) return s;
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r){
            char lc = chars[l];
            char rc = chars[r];
            if(!isVowel(lc)) l++;
            else if(!isVowel(rc)) r--;
            else swap(chars, l++, r--);

        }
        return new String(chars);
    }

    private static boolean isVowel(char c){
        c = Character.toLowerCase(c);
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') return true;
        else return false;
    }

    private static void swap(char[] arr, int l, int r){
        char c = arr[l];
        arr[l] = arr[r];
        arr[r] = c;
    }

    public static void main(String[] args){
        String s = "a.b,.";
        String s1 = reverseVowels(s);
        System.out.println(s1);
    }
}
