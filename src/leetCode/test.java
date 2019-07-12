package leetCode;
import org.junit.Test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 大位数乘法，通过String类型接收用户输入的数字，并按位存进Map集合中，
 * 之后模拟乘法手算的过程，用乘数的每一位，去乘被乘数的每一位，将结果按位保存在新的Map集合中
 * @author Eric
 *
 */
public class test {
    static Map<Integer, Integer> map1 = new TreeMap<Integer, Integer>(); // 存放用户输入的第一个数字，键为数字所在位数，值为该位的数字。
    static Map<Integer, Integer> map2 = new TreeMap<Integer, Integer>(); // 存放用户输入的第二个数字，含义与map1相同。
    static Map<Integer, Integer> map3 = new TreeMap<Integer, Integer>(); // 存放计算出的结果，键与值的含义与mpa1相同。

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next(); // 接收用户输入的第一个数字
        String b = in.next(); // 接收用户输入的第二个数字
        map1=saveToMap(a);
        map2=saveToMap(b);
        map3=calc(map1, map2);
        String result=getResult(map3);
        System.out.println(result);
//      BigInteger s1=new BigInteger(a);
//      BigInteger s2=new BigInteger(b);
//      System.out.println("验算的答案是："+s1.multiply(s2));
    }

    /**
     * 将用户输入的字符串按位存入map集合中的方法
     * @param number 传入的参数为用户输入的字符串
     * @return 返回存完数字的map集合
     * 由于传入的String类型的最后1位应该是Map集合的第1位，
     * 因此放入Map集合时是从number.length位放至1位的
     */
    public static Map<Integer, Integer> saveToMap(String number) {
        Map<Integer, Integer> mapTemp = new TreeMap<Integer, Integer>();
        int length = number.length();
        for (int m = 1; m <= number.length(); m++) {
            mapTemp.put(length--, Integer.parseInt(number.substring(m - 1, m)));
        }
        return mapTemp;
    }

    /**
     * 通过嵌套2个for循环，实现map1里面每一个数字与map2里的每一个数字依次相乘，
     * 每次相乘后会判断得数是1位数还是2位数，如果乘积是1位数，调用一次addNumber()方法，
     * 如果是2位数，则调用2次addNumber()方法，将乘积的个位和十位添加分别添加至第n位和第n+1位
     * @param map1 用户输入的被乘数
     * @param map2 用户输入的乘数
     * @return 保存了运算结果的Map集合
     */
    public static Map<Integer, Integer> calc(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        Map<Integer, Integer> mapTemp1 = new TreeMap<Integer, Integer>();
        for (int total = 1; total <= map1.size() + map2.size(); total++) {
            mapTemp1.put(total, 0);
        }
        for (int i = 1; i <= map1.size(); i++) {
            for (int k = 1; k <= map2.size(); k++) {
                int result1 = map1.get(i) * map2.get(k);
                int currentNum = k + i - 1;
                if (result1 / 10 == 0) {
                    addNumber(currentNum, result1,mapTemp1);
                } else {
                    addNumber(currentNum, result1 % 10,mapTemp1);
                    addNumber(currentNum + 1, result1 / 10,mapTemp1);
                }
            }
        }
        return mapTemp1;
    }

    /**
     * 将运算结果保存至该位的运算方法，主要用来解决数字相加后大于9的进位问题
     * @param currentNum 结果应该放入的位置（位数）
     * @param result 需要放入该位置的数值
     * @param resultMap 存放最终运算结果的map集合
     */
    public static void addNumber(int currentNum, int result,Map<Integer, Integer> resultMap) {
        int resultTem = resultMap.get(currentNum) + result;
        if (resultTem / 10 == 0) {
            resultMap.put(currentNum, resultTem);
        } else {
            resultMap.put(currentNum, resultTem % 10);
            addNumber(currentNum + 1, resultTem / 10,resultMap);
        }
    }

    /**
     * 将map3里面的结果转换成String类型以便最终显示给用户的方法
     * @param resultMap
     * @return
     */
    public static String getResult(Map<Integer, Integer> resultMap){
        String result="";
        for (int g = resultMap.size(); g >= 1; g--) {
            if (resultMap.get(g) == 0 && result.equals("")) {
            } else {
                result += resultMap.get(g) + "";
            }
        }
        return result;
    }

    @Test
    public void plusTest(){
        int i = 9,j = 20;
        int k = (i+j)/2;
        assert k == 14;
        //如果i+j超过了整形的范围的话，可以按照下面的方式做
        assert 14 == i+(j-i)/2;

    }
}