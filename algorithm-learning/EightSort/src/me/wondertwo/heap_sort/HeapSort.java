package me.wondertwo.heap_sort;

/**
 * 堆排序  不稳定   O(nlogn)
 *
 * Created by wondertwo on 2016/8/3.
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {0, 99, 41, 17, 71, 44, 92, 63, 59, 40, 27};
        print(arr);
        heapSort(arr);
        print(arr);
    }

    private static void heapSort(int[] arr) { //递归实现
        int n = arr.length; //数组元素个数
        //对所有数组元素构建大顶堆
        for(int i = n/2-1; i >= 0; i--) {toMaxHeap(arr, i, n);}
        for(int j = n-1; j >= 1; j--) {
            //此时堆顶元素是最大元素，交换堆顶元素和数组最后一位元素
            swap(arr, 0, j);
            //继续把前面n-1个元素构建大顶堆
            toMaxHeap(arr, 0, j);
        }
    }

    private static void toMaxHeap(int[] arr, int idx, int max) {
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
            toMaxHeap(arr, largest, max); //递归
        }
    }

    private static void swap(int[] data, int i, int j) {
        if (i == j) {return;}
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    private static void print(int[] data) {
        for (int aData : data) {System.out.print(aData + "\t");}
        System.out.println();
    }
}
