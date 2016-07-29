package me.wondertwo.swf137;

import java.util.ArrayList;

/**
 * 模拟栈：由多个子栈来组合模拟出      page138
 *
 * Created by Allenieo on 2016/5/2.
 */
public class SetOfStacks {
    private ArrayList<CustomStack> stacks = new ArrayList<>();
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    private CustomStack getLastStack() {
        if (0 == stacks.size()) {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }

    public void push(int value) {
        CustomStack last = getLastStack();
        if (last != null && !last.isFull()) {
            last.push(value);
        } else {
            CustomStack stack = new CustomStack(capacity);
            stack.push(value);
            stacks.add(stack);
        }
    }

    public int pop() {
        CustomStack last = getLastStack();
        int value = last.pop();
        if (last.size == 0) {
            stacks.remove(stacks.size() - 1);
        }
        return value;
    }

    private int leftShift(int index, boolean remove_top) {
        CustomStack stack = stacks.get(index);
        int removed_item;
        if (remove_top) {
            removed_item = stack.pop();
        } else {
            removed_item = stack.removeBottom();
        }
        if (stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int value = leftShift(index + 1, false);
            stack.push(value);
        }
        return removed_item;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }
}
