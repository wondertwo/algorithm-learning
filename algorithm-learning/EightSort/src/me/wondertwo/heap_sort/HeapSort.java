package me.wondertwo.heap_sort;

import java.util.Arrays;

/**
 * 堆排序：  时间复杂度O(nlogn)，对原始记录的排序状态并不敏感，因此最好、最坏和平均时间复杂度均为O(nlogn)
 *          空间复杂度：O(1) 只需要一个用作交换的暂存单元；
 *          由于记录的比较是跳跃式的，因此堆排序是一种不稳定的排序算法。
 *
 * Created by wondertwo on 2016/8/3.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0, 99, 41, 17, 3, 54, 71, 100, 101, 44, 92, 63, 59, 40, 27};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序，递归实现
     */
    private static void heapSort(int[] arr) {
        int n = arr.length;//数组元素个数
        //对所有数组元素构建大顶堆
        for(int i = n/2-1; i >= 0; i--) {
            toHeap(arr, i, n);
        }
        for(int j = n-1; j >= 1; j--) {
            //此时堆顶元素是最大元素，交换堆顶元素和数组最后一位元素
            swap(arr, 0, j);
            //此时最大元素在数组最后一位，继续把前面（n-1）个数组元素构建大顶堆
            toHeap(arr, 0, j);
        }
    }

    /**
     * 构建大顶堆，递归
     */
    private static void toHeap(int[] arr, int idx, int max) {
        int left = 2*idx + 1; //左孩子下标
        int right = 2*idx + 2; //左孩子下标
        int largest; //寻找3个节点中最大值节点下标
        if(left < max && arr[left] > arr[idx]) {
            largest = left;
        } else {
            largest = idx;
        }
        if(right < max && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != idx) {
            swap(arr, largest, idx);
            toHeap(arr, largest, max); //递归
        }
    }

    /**
     * 交换函数
     */
    private static void swap(int[] arr, int lar, int idx) {
        int temp = arr[lar];
        arr[lar] = arr[idx];
        arr[idx] = temp;
    }
}
