package me.wondertwo.heap_sort;

/**
 * Created by wondertwo on 2016/8/4.
 */
public class HeapSort2 {

    public static void main(String[] args) {
        int[] arr = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
        print(arr);
        heapSort(arr);
        print(arr);
    }

    private static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            createMaxHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
            print(data);
        }
    }

    private static void createMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点
            int k = i; // 若当前节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        // 若右子节点值比左子节点值大，则biggerIndex++
                        biggerIndex++;
                    }
                }
                if (data[k] < data[biggerIndex]) {
                    // 若当前节点值小于子节点最大值，则交换两者的值
                    swap(data, k, biggerIndex);
                    k = biggerIndex; // 交换后将biggerIndex值赋值给k
                } else {
                    break;
                }
            }
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
