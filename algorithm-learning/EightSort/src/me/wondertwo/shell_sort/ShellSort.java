package me.wondertwo.shell_sort;

/**
 * 希尔排序   不稳定   O(nlogn)
 *
 * Created by wondertwo on 2016/8/2.
 */
public class ShellSort {
    public static void main(String[] args) {
        //length=8,其中arr[0]作为辅助空间，可传入原数组后做处理，
        //在数组最前面添加一个元素0，即arr[0]=0
        int[] arr = {0, 99, 41, 17, 3, 54, 71, 100, 101, 29};
        print(arr);
        shellSort(arr);
        print(arr);
    }

    private static void shellSort(int[] arr) {
        int i, j;
        int increment = arr.length; //定义分割间隔
        do {
            //通过increment把数组分为前后两部分
            increment = increment/3 + 1;
            //此时increment标记后部分元素的首位元素下标，记为后1,从后1开始循环，
            //依次成对和前部分数组元素进行大小比较,即后1和前1进行比较，后2和前2进行比较，
            // 前1是指arr[1]，因为arr[0]是辅助空间
            for (i = increment+1; i < arr.length; i++) {
                //比较后1和1前1的大小关系，若后1值较小则进行位置交换
                if (arr[i] < arr[i-increment]) {
                    //arr[0]作为辅助空间，暂存后1值
                    arr[0] = arr[i];
                    //此处循环的作用：将前1值赋值给后1
                    for (j=i-increment; j>0 && arr[0]<arr[j]; j-=increment) {
                        arr[j+increment] = arr[j];
                    }
                    //将arr[0]赋值给前1
                    arr[j+increment] = arr[0];
                }
            }
        } while (increment > 1);
        //循环结束，排序结束。arr[0]为辅助空间，将其值重新恢复为0
        arr[0] = 0;
    }

    private static void print(int[] data) {
        for (int aData : data) {System.out.print(aData + "\t");}
        System.out.println();
    }
}
