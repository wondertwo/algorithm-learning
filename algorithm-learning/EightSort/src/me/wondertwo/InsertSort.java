package me.wondertwo;

import java.util.Arrays;

/**
 * 插入排序
 *      空间复杂度：需要一个额外的内存空间作为辅助空间
 *      时间复杂度：O(n^2)
 *
 * Created by wondertwo on 2016/8/2.
 */
public class InsertSort {

    public static void main(String[] args) {
        //length=8,其中arr[0]作为辅助空间，
        //可传入原数组后做处理，在数组最前面添加一个元素0
        //即arr[0]=0;
        int[] arr = {0, 99, 41, 17, 3, 54, 71, 100};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int i, j;
        //以arr[1]作为基准，从arr[2]开始判断
        for (i = 2; i < arr.length; i++) {
            //将arr[i]插入有序子表
            if (arr[i] < arr[i-1]) {
                //作为辅助空间，暂存需要插入的值
                arr[0] = arr[i];
                for (j = i-1; arr[j] > arr[0]; j--) {
                    arr[j+1] = arr[j]; //记录后移
                }
                arr[j+1] = arr[0]; //插入到正确的位置
            }
        }
        arr[0] = 0; //arr[0]恢复为初始值0
    }
}
