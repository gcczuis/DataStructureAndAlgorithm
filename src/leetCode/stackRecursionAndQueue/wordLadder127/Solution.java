package leetCode.stackRecursionAndQueue.wordLadder127;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * {@author: gcc}
 * {@Date: 2019/6/27 21:40}
 */
public class Solution {
    private boolean[] used;
    private int[] memo;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        memo = new int[wordList.size()];
        Arrays.fill(memo, 1000);
        used = new boolean[wordList.size()];
        int ret = 1000;

        for (int i = 0; i < wordList.size(); i++) {
            if (!used[i] && canTransform(beginWord, wordList.get(i))) {
                used[i] = true;
                int x = find(wordList.get(i), endWord, wordList, i);

                ret = Integer.min(ret, 2 + x);
                used[i] = false;
            }
        }

        return ret > 100 ? 0 : ret;
    }

    //从beginWord开始到endWord最少需要多少次变换，index是beginWord在wordList中的索引号
    private int find(String beginWord, String endWord, List<String> wordList, int index) {
        if (beginWord.equals(endWord)) {
            return memo[index] = 0;
        }
        if (memo[index] < 100) {
            return memo[index];
        }

        for (int i = 0; i < wordList.size(); i++) {
            if (!used[i] && canTransform(beginWord, wordList.get(i))) {
                used[i] = true;
                memo[index] = Integer.min(memo[index], 1 + find(wordList.get(i), endWord, wordList, i));
                used[i] = false;
            }
        }
        return memo[index];
    }

    private boolean canTransform(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    //规模到了下面这个级别就会超时
    @Test
    public void test(){
        List<String> list = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");

        memo = new int[list.size()];
        Arrays.fill(memo, 1000);
        used = new boolean[list.size()];
        System.out.println(ladderLength("qa","sq",list));
    }
}
