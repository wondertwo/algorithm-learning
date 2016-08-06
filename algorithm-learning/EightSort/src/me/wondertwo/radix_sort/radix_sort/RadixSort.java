package me.wondertwo.radix_sort.radix_sort;

import java.util.Arrays;

/**
 * 基数排序   稳定   线性时间
 * Created by wondertwo on 2016/8/6.
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] data = {1100, 192, 101, 998, 34, 901, 2344, 7689,
                41, 221, 12, 23};
        print(data);
        radixSort(data, 10, 4);
        System.out.println("--------------------");
        print(data);
    }

    /**
     * @param radix 待排数据为十进制，为计算每个数据的子关键字，radix=10
     * @param d     待排数据最高位是 d 位数
     */
    private static void radixSort(int[] data, int radix, int d) {
        // 缓存数组
        int[] tmpArr = new int[data.length];
        // buckets用于记录待排序元素的信息
        // buckets数组定义了max-min个桶
        int[] buckets = new int[radix];

        // 低位优先，循环变量 i 由0到(d-1)
        for (int i = 0, rate = 1; i < d; i++) {

            // 重置 buckets 数组，开始统计下一个关键字
            Arrays.fill(buckets, 0);
            // 将data中的元素完全复制到tmp数组中
            System.arraycopy(data, 0, tmpArr, 0, data.length);

            // 计算每个待排序数据的子关键字
            for (int j = 0; j < data.length; j++) {
                int subKey = (tmpArr[j] / rate) % radix;
                buckets[subKey]++;
            }

            for (int j = 1; j < radix; j++) {
                buckets[j] = buckets[j] + buckets[j - 1];
            }

            // 按子关键字对指定的数据进行排序
            for (int m = data.length - 1; m >= 0; m--) {
                int subKey = (tmpArr[m] / rate) % radix;
                data[--buckets[subKey]] = tmpArr[m];
            }
            rate *= radix;
        }
    }

    private static void print(int[] data) {
        for (int aData : data) {System.out.print(aData + "\t");}
        System.out.println();
    }
}
