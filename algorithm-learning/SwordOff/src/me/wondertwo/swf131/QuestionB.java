package me.wondertwo.swf131;

/**
 * 弹性分割，允许栈的大小灵活变化，当一个栈的元素个数超出其容量的时候，就将
 * 这个栈扩容至许可的容量，必要时还需要搬移元素。
 * 我们会将数组设计成环形结构，最后一个栈可能从数组的末尾开始，环绕到数组开头。
 *
 * Created by wondertwo on 2016/6/6.
 */
public class QuestionB {

    private static int number_of_stacks = 3;
    private static int default_size = 4;
    private static int total_size = default_size * number_of_stacks;
    private static StackData[] stacks = {new StackData(0, default_size),
            new StackData(default_size, default_size),
            new StackData(default_size * 2, default_size)};
    private static int[] buffer = new int[total_size];

    public static void main(String[] args) throws Exception {
        push(0, 10);
        push(0, 10);
        push(0, 10);
        int value = pop(0);
    }

    private static int numberOfElements() {
        return stacks[0].size + stacks[1].size + stacks[2].size;
    }

    private static int nextElement(int index) {
        if (index + 1 == total_size) {
            return total_size -1;
        } else {
            return index + 1;
        }
    }

    private static int previousElement(int index) {
        if (index == 0) {
            return total_size;
        } else {
            return index - 1;
        }
    }

    private static void shift(int stackNum) {
        StackData stack = stacks[stackNum];
        if (stack.size >= stack.capacity) {
            int nextStack = (stackNum + 1) % number_of_stacks;
            shift(nextStack); // 腾出若干空间
            stack.capacity++;
        }

        // 以相反顺序搬移元素
        for (int i = (stack.start + stack.capacity - 1) % total_size;
             stack.isWithinStack(i, total_size);
             i = previousElement(i)) {
            buffer[i] = buffer[previousElement(i)];
        }

        buffer[stack.start] = 0;
        stack.start = nextElement(stack.start); // 移动栈的起始位置
        stack.pointer = nextElement(stack.pointer); // 移动指针
        stack.capacity--; // 恢复到原先的容量
    }

    /*搬移到其他栈上，以扩大栈的容量*/
    private static void expand(int stackNum) {
        shift((stackNum + 1) % number_of_stacks);
        stacks[stackNum].capacity++;
    }

    private static void push(int stackNum, int value) throws Exception {
        StackData stack = stacks[stackNum];
        /*检查空间够不够*/
        if (stack.size >= stack.capacity) {
            if (numberOfElements() >= total_size) { // 全部都装满了
                throw new Exception("out of space!");
            } else { // 只需要搬移元素
                expand(stackNum);
            }
        }
        /*找出栈顶元素在数组中的索引值，并+1，并增加栈指针*/
        stack.size++;
        stack.pointer = nextElement(stack.pointer);
        buffer[stack.pointer] = value;
    }

    private static int pop(int stackNum) throws Exception {
        StackData stack = stacks[stackNum];
        if (stack.size == 0) {
            throw new Exception("trying to pop an empty stack!");
        }
        int value = buffer[stack.pointer];
        buffer[stack.pointer] = 0;
        stack.pointer = previousElement(stack.pointer);
        stack.size--;
        return value;
    }

    public static int peek(int stackNum) {
        StackData stack = stacks[stackNum];
        return buffer[stack.pointer];
    }

    public static boolean isEmpty(int stackNum) {
        StackData stack = stacks[stackNum];
        return stack.size == 0;
    }
}
