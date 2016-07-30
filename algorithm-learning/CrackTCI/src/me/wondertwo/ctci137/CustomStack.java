package me.wondertwo.ctci137;

import java.util.Stack;

/**
 * 自定义子栈
 */
public class CustomStack {

    private Stack<Integer> stack;
    private int capacity;
    public int size;

    public CustomStack(int capacity) {
        this.stack = new Stack<>();
        this.capacity = capacity;
        size = stack.size();
    }

    public boolean isFull() {
        return capacity == size;
    }

    public boolean push(int value) {
        if (size >= capacity) {
            return false;
        }
        stack.push(value);
        size = stack.size();
        return true;
    }

    public int pop() {
        size = stack.size() - 1;
        return stack.pop();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeBottom() {
        size = stack.size() - 1;
        return stack.remove(0);
    }
}
