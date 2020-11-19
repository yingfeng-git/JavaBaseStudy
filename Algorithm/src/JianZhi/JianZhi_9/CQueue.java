package JianZhi.JianZhi_9;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双栈队列，一个写栈，一个删除栈。用了两种方法来实现：
 * 1. 用数组实现队列，维护写下标及删除下标来确认栈顶位置。
 *    写的时候直接写入写栈，删除时如果删除栈里有元素，直接
 *    删除并返回，如果删除栈为空就去看一下写栈是否为空，若
 *    不为空则把写栈倒序放入删除栈，若为空返回-1。
 *
 */
class CQueue {
    int[] writerStack = new int[10000];
    int[] deleteStack = new int[10000];
    int writerIndex = -1;
    int deleteIndex = -1;
    public CQueue() {
    }

    public void appendTail(int value) {
        writerStack[++writerIndex] = value;
    }

    public int deleteHead() {
        if (deleteIndex >= 0) return deleteStack[deleteIndex--];
        if (writerIndex < 0) return -1;
        while (writerIndex >= 0){
            deleteStack[++deleteIndex] = writerStack[writerIndex--];
        }
        return deleteStack[deleteIndex--];
    }
}

class CQueue2 {
    Deque<Integer> writerStack = new LinkedList<>();
    Deque<Integer> deleteStack = new LinkedList<>();
    public CQueue2() {
    }

    public void appendTail(int value) {
        writerStack.push(value);
    }

    public int deleteHead() {
        if (!deleteStack.isEmpty()) return deleteStack.pop();
        if (writerStack.isEmpty()) return -1;
        while (!writerStack.isEmpty())
            deleteStack.push(writerStack.pop());
        return deleteStack.pop();
    }
}

class CQueue3 {
    Deque<Integer> writerStack = new LinkedList<>();
    Deque<Integer> deleteStack = new LinkedList<>();
    public CQueue3() {
    }

    public void appendTail(int value) {
        if (writerStack.isEmpty())
            while(!deleteStack.isEmpty())
                writerStack.push(deleteStack.pop());
        writerStack.push(value);
    }

    public int deleteHead() {
        if (deleteStack.isEmpty()) while (!writerStack.isEmpty()) deleteStack.push(writerStack.pop());
        return deleteStack.isEmpty()? -1: deleteStack.pop();
    }
}