package me.wondertwo.swf142;

import java.util.Stack;

/**
 * 用两个栈实现一个队列   p142-3.5
 */
public class StackToQueue<T> {

    Stack<T> stackNewest, stackOldest;

    public StackToQueue(Stack<T> stackNewest, Stack<T> stackOldest) {
        this.stackNewest = stackNewest;
        this.stackOldest = stackOldest;
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}
