package algorithm.advancedSort;

import java.util.Scanner;

/**
 * @author: gcc
 * @Date: 2018/9/9 19:06
 * @Description:
 */
public class test {

    public static  class obj{
        public int i;
        public int j;
        public int k;

        public obj(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }
    public static void main(String[] args){
        int ret = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        obj[] objs = new obj[n];
        for (int i = 0; i < n; i++) {
            objs[i] = new obj(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(objs[i].i < objs[j].i && objs[i].j < objs[j].j && objs[i].k < objs[j].k){
                    ret ++;
                }
            }
        }
        System.out.println(ret);

    }
}
