package me.wondertwo.swf135;

import java.util.Stack;

/**
 * Created by wondertwo on 2016/5/30.
 */
public class StackWithMin_2 extends Stack<Integer> {

    Stack<Integer> stack;

    public StackWithMin_2() {
        stack = new Stack<Integer>();
    }

    public void push(int value) {
        if (value <= min()) {
            stack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            stack.pop();
        }
        return value;
    }

    public int min() {
        if (stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stack.peek();
        }
    }
}
