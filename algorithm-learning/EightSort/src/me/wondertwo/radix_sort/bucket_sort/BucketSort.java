package me.wondertwo.radix_sort.bucket_sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 桶排序    稳定   线性时间
 *
 * Created by wondertwo on 2016/8/5.
 */
public class BucketSort {

    public static void main(String[] args) {
        // 所有待排元素满足：均匀分布在区间[0, 1)
        double[] array = { 0.78, 0.17, 0.39, 0.26, 0.72, 0.94,
                0.21, 0.12, 0.23, 0.68 };
        print(array);
        bucketSort(array);
        System.out.println("----------------------");
        print(array);
    }

    private static void bucketSort(double[] array) {
        /**
         *  把待排元素区间均分为 bucketNum 个桶
         *  每个桶是一个list，存放落在此桶上的元素
         */
        int bucketNum = array.length; // 桶的个数
        ArrayList[] arrList = new ArrayList[bucketNum];

        // 存放落在每个桶中的元素
        for (double anArray : array) {
            //0.7到0.79放在第8个桶里，编号7；第一个桶放0到0.09
            int temp = (int) Math.floor(10 * anArray);
            if (null == arrList[temp]) {
                arrList[temp] = new ArrayList();
            }
            arrList[temp].add(anArray);
        }

        // 对每个桶中的数进行插入排序
        for (int i = 0; i < bucketNum; i++) {
            if (null != arrList[i]) {
                // 此处排序方法不定，越快越好，除了三大线性排序外，都没有
                // Collections和Arrays里的sort好，因为这是调优后的快排，
                // Arrays里也有，在基数排序里用过copyOf和fill方法
                Collections.sort(arrList[i]);
            }
        }

        // 输出类似鸽巢排序
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            if (null != arrList[i]) {
                for (Object o : arrList[i]) {
                    Double d = (Double) o;
                    array[index] = d;
                    index++;
                }
            }
        }
    }

    private static void print(double[] data) {
        for (double aData : data) {
            System.out.print(aData + "\t");
        }
        System.out.println();
    }
}
