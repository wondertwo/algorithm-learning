package me.wondertwo.ctci331;

/**
 * Created by wondertwo on 2016/9/1.
 */
public class PrintEdge {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrderPrint(matrix);
    }

    public static void spiralOrderPrint(int[][] matrix) {
        //若想分层打印，则只需当前层的左上角坐标和右下角坐标即可定位当前打印的那一层
        int tr = 0, tc = 0; //记录矩阵左上角坐标
        int dr = matrix.length - 1, dc = matrix.length - 1; // 记录矩阵右下角坐标

        //循环打印。每打印一层左上角坐标同时+1，右下角坐标同时-1
        while (tr <= dr && tc <= dc) {
            printResult(matrix, tr++, tc++, dr--, dc--);
        }
    }

    private static void printResult(int[][] matrix, int tr, int tc, int dr, int dc) {
        /**
         * 只有一行的情况
         */
        if (tr == dr) {
            for (int i = tc; i <= dc; i++) {
                System.out.print(matrix[tr][i] + "  ");
            }
        }

        /**
         * 只有一列的情况
         */
        if (tc == dc) {
            for (int i = tr; i <= dr; i++) {
                System.out.print(matrix[i][tc] + "  ");
            }
        }

        /**
         * 正常情况
         */
        int currentC = tc, currentR = tc;
        while (currentC != dc) {
            System.out.print(matrix[tr][currentC] + "  ");
            currentC++;
        }
        while (currentR != dr) {
            System.out.print(matrix[currentR][dc] + "  ");
            currentR++;
        }
        while (currentC != tc) {
            System.out.print(matrix[dr][currentC] + "  ");
            currentC--;
        }
        while (currentR != tr) {
            System.out.print(matrix[currentR][tc] + "  ");
            currentR--;
        }
    }
}
