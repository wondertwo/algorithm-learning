package me.wondertwo.swf131;

/**
 * StackData存放每个站相关的数据，但并未存放栈实际的元素
 *
 * Created by wondertwo on 2016/6/6.
 */
class StackData {

    int start;
    int pointer;
    int size = 0;
    int capacity;

    StackData(int start, int capacity) {
        this.start = start;
        this.pointer = start - 1;
        this.capacity = capacity;
    }

    boolean isWithinStack(int index, int total_size) {
        if (start <= index && index < start + capacity) {
            return true;
        } else if (start + capacity > total_size && index < (start + capacity) % total_size) {
            return true;
        }
        return false;
    }
}
