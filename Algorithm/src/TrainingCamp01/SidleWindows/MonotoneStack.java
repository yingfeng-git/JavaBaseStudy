package TrainingCamp01.SidleWindows;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈，求数组中所有元素左边和右边离它最近比它小的数
 * 首先建立一个栈，保证栈中从下到上是从小到大的
 * 遇到小的进行处理，大的压栈。
 * 核心思想是找到计算的左右边界
 */
public class MonotoneStack {
    public static int[][] process(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[][] ans = new int[arr.length][2];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[stack.lastElement()]) {
                while(!stack.isEmpty() && arr[i] < arr[stack.lastElement()]) {
                    int pop = stack.isEmpty()? -1: stack.pop();
                    ans[pop][0] = stack.isEmpty()? -1 : stack.lastElement();
                    ans[pop][1] = i;
                }
            }
            stack.push(i);
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            int pop = stack.pop();
            ans[pop][0] = stack.isEmpty()? -1 : stack.lastElement();
            ans[pop][1] = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] test = {1, 5, 3, 6, 0, 2, 4, 8};
        /*
         *  0 <- 1 -> 2   1 3
         *  2 <- 3 -> 4   1 3 6
         *  0 <- 2 -> 4   1 3
         * -1 <- 0 -> 4   0 2 4 8
         *  6 <- 7 -> -1  0 2 4
         *  5 <- 6 -> -1  0 2
         *  4 <- 5 -> -1  0
         * -1 <- 4 -> -1
         */
        int[][] process = process(test);
        for (int[] ints : process) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
