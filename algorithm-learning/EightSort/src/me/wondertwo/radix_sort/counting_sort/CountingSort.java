package me.wondertwo.radix_sort.counting_sort;

/**
 * 计数排序     稳定      线性时间
 *
 * Created by wondertwo on 2016/8/6.
 */
public class CountingSort {
    public static void main(String[] args) {
        //待排序元素所在区间[0, max]， 所以待排元素最大值为max=100
        int[] arr = {64, 44, 99, 41, 17, 44, 54, 71, 10, 81, 100, 0,
                92, 63, 71, 40, 27};
        print(arr);
        System.out.println("--------------------------------");
        print(countingSort(arr, 100));
    }

    private static int[] countingSort(int[] arr, int max) {
        // 辅助数组，存储最终的输出序列
        int[] OutputTemp = new int[arr.length];
        // 记录数组，记录每个输入元素在输出序列中的位置
        int[] CacheCount = new int[max+1];

        // 初始化记录数组，初始值0
        for (int b = 0; b <= max; b++) {CacheCount[b] = 0;}

        // 循环遍历，统计每个数据出现的次数，保存在CacheCount相应位置
        for (int anArr : arr) {
            CacheCount[anArr] = CacheCount[anArr] + 1;
        }
        // 循环结束，记录数组中已经记录着每个输入元素的个数

        // 从第一个位置开始遍历记录数组，满足条件：
        // CacheCount[j] = CacheCount[j] + CacheCount[j-1]
        // 此公式可计算出每个输入元素，对应在输出序列中位置
        for (int j = 1; j <= max; j++) {
            CacheCount[j] += CacheCount[j-1];
        }

        // 倒叙遍历待排序数组，将每个元素放到辅助数组中其对应的输出位置即可
        for (int t = arr.length-1; t >= 0; t--) {
            // 为了与待排数组下标对应，输出数组OutputTemp[]下标减1
            OutputTemp[CacheCount[arr[t]]-1] = arr[t];
            // 可能待排数组中有重复元素，CacheCount 减1后，
            // 方便第二个出现的重复元素放在倒数第二个重复的位置上
            CacheCount[arr[t]]--;
        }
        return OutputTemp;
    }

    private static void print(int[] data) {
        for (int aData : data) {System.out.print(aData + "\t");}
        System.out.println();
    }
}
