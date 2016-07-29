package me.wondertwo.swf140;

import java.util.Stack;

/**
 * 汉诺塔问题求解算法        p140-3.4
 */
public class HanoiTower {

    private static Stack<Integer> disks;
    private int index;

    private HanoiTower(int index) {
        disks = new Stack<>();
        this.index = index;
    }

    private int getIndex() {
        return index;
    }

    private void initial(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("some errors at placing " + d);
        } else {
            disks.push(d);
        }
    }

    private void moveTop(HanoiTower hanoiTower) {
        int top = disks.pop();
        hanoiTower.initial(top);
        System.out.println("initial disk " + top + "from " + getIndex() + "to " + hanoiTower.getIndex());
    }

    private void moveDisks(int n, HanoiTower destination, HanoiTower buffer) {
        if (n>0) {
            moveDisks(n-1, buffer, destination);
            moveTop(destination);
            buffer.moveDisks(n-1, destination, this);
        }
    }

    public static void main(String[] args) {
        int INITIAL_SIZE = 3;
        HanoiTower[] hanoiTowers = new HanoiTower[INITIAL_SIZE];
        for (int i = 0; i < INITIAL_SIZE; i++) {
            hanoiTowers[i] = new HanoiTower(i);
        }

        for (int i = INITIAL_SIZE - 1; i >= 0; i--) {
            hanoiTowers[0].initial(i);
        }
        hanoiTowers[0].moveDisks(INITIAL_SIZE, hanoiTowers[2], hanoiTowers[1]);
    }
}
