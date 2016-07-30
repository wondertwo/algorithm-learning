package me.wondertwo.ctci135;

import java.util.Stack;

/**
 * Created by wondertwo on 2016/5/30.
 */
public class StackWithMin_1 extends Stack<NodeWithMin> {

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}
