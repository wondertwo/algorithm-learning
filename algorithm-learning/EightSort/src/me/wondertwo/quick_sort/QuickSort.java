package me.wondertwo.quick_sort;

/**
 * O(nlogn) 不稳定  O(logn)
 *
 * Created by wondertwo on 2016/8/5.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {44, 99, 41, 17, 3, 54, 71, 10, 81, 0, 92,
                63, 59, 40, 27};
        print(arr);
        quickSort(arr, 0, arr.length-1);
        System.out.println("--------------------------------");
        print(arr);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int center = partition(arr, low, high);
        quickSort(arr, low, center-1);
        quickSort(arr, center+1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int centerValue = arr[getCenter(arr, low, high)]; //三数取中
        while (low < high) {
            while (low < high && arr[high]>= centerValue) {
                high--;
            }
            swap(arr, low, high);
            print(arr);
            while (low < high && arr[low] <= centerValue) {
                low++;
            }
            swap(arr, low, high);
            print(arr);
        }
        return low;
    }

    // find more suitable center value's index
    private static int getCenter(int[] arr, int low, int high) {
        int mid = (low + high) /2;
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        return low; //???????????为什么返回low?
    }

    private static void swap(int[] data, int i, int j) {
        if (i == j) return;
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    private static void print(int[] data) {
        for (int aData : data) {System.out.print(aData + "\t");}
        System.out.println();
    }
}
