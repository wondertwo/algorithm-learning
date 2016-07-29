package me.wondertwo.cig402;

/**
 * Created by wondertwo on 2016/7/29.
 */
public class Cig402 {

    public static void main(String[] args) {
        printProcess(1, 5, true);
    }

    public static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(i+1, n, true);
        System.out.println(down ? "down" : "up");
        printProcess(i+1, n, false);
    }

}
