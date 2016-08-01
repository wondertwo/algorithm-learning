package me.wondertwo.cig001;

import java.util.Stack;

/**
 * Created by wondertwo on 2016/8/1.
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1(Stack<Integer> stackData, Stack<Integer> stackMin) {
        this.stackData = stackData;
        this.stackMin = stackMin;
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum); // 更新stackMin
        } else if (newNum <= getMin()) {
            this.stackMin.push(newNum); // 压栈向stackData栈中压入
        }
        this.stackData.push(newNum);
    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop(); // 弹栈从stackData中弹出
        if (value == getMin()) {
            this.stackMin.pop(); // 更新stackMin栈
        }
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }
}
