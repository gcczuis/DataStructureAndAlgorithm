package leetCode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author: gcc
 * @Date: 2018/9/16 17:03
 * @Description:
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        BigInteger s1 = new BigInteger(sc.next());
        BigInteger s2 = new BigInteger(sc.next());
        System.out.println(s1.multiply(s2));
    }
}
