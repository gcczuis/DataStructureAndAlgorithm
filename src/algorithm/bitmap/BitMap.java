package algorithm.bitmap;

/**
 * {@author: gcc}
 * {@Date: 2019/7/12 14:31}
 */

/**
 * Created by gcc on 2019/07/02.
 * 位图
 */
public class BitMap {
    // 实际使用int数组存储
    private int[] data;

    /**
     * 构造方法,传入预期的最大index.
     */
    public BitMap(int size) {
        //注意数组容量是size/32+1，因为如果你传入一个size通常是整数集中最大数的值，假设是32，那么其实需要存储0-32这33
        //个数，所以1个int不足以表示33个数，故而需要size/32+1
        this.data = new int[(size >> 5) + 1];
    }

    /**
     * get 方法, 传入要获取的index, 返回bool值代表该位上为1/0
     */
    public boolean get(int bitIdx) {
        return (data[bitIdxToWorkIdx(bitIdx)] & (1 << bitIdx)) != 0;
    }

    /**
     * 将对应位置的值设置为传入的bool值
     */
    public void set(int idx, boolean v) {
        if (v) {
            set(idx);
        } else {
            clear(idx);
        }
    }

    // 将index的值设置为1
    private void set(int idx) {
        data[bitIdxToWorkIdx(idx)] |= 1 << idx;
    }

    // 将index上的值设置为0
    private void clear(int bitIdx) {
        //除了指定位是0其余全是1，来将指定位设置为0
        data[bitIdxToWorkIdx(bitIdx)] &= ~(1 << bitIdx);
    }

    // 根据bit的index获取存储他的实际int在数组中的index
    private int bitIdxToWorkIdx(int bitIdx) {
        return bitIdx >> 5;
    }

    public static void main(String[] args) {

        BitMap t = new BitMap(64);
        t.set(64, true);

        System.out.println(t.get(64));
      /*  System.out.println(t.get(80));
        t.clear(80);
        System.out.println(t.get(80));*/
        System.out.println(64 >> 5);

    }
}