package me.wondertwo.swf131;

/**
 * 解法一：固定分割，为每个栈分配固定大小的内存空间。
 *
 * Created by wondertwo on 2016/6/6.
 */
public class ArrayToStack {

    private int stackSize = 100;
    private int[] buffer = new int[stackSize * 3];
    private int[] stackPointer = {-1, -1, -1}; // 用于追踪栈顶指针

    public void push(int stackNum, int value) throws Exception {
        /*检查有无可用空间*/
        if (stackPointer[stackNum] + 1 >= stackSize) {
            throw new Exception("out of space!");
        }
        /*栈顶指针自增*/
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    public int pop(int stackNum) throws Exception {
        /*检查栈是否为空*/
        if (stackPointer[stackNum] == -1) {
            throw new Exception("trying to pop an empty stack");
        }
        int value = buffer[absTopOfStack(stackNum)]; // 取栈顶元素的值
        stackPointer[stackNum]--; // 指针自减
        return value;
    }

    public int peek(int stackNum) {
        return buffer[absTopOfStack(stackNum)];
    }

    /*返回栈stackNum的栈顶元素的索引，绝对值*/
    private int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }

}
