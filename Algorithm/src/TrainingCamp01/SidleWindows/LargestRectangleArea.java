package TrainingCamp01.SidleWindows;

import java.util.Arrays;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 使用单调栈来解
 */
public class LargestRectangleArea {

    public static int largestRectangleArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] areas = new int[arr.length];
        int max = 0;
        stack.push(0);

        for (int i = 1; i < arr.length; i++) {
            if (arr[stack.lastElement()] > arr[i]) {
                while (!stack.isEmpty() && arr[stack.lastElement()] > arr[i]) {
                    int pop = stack.pop();
                    int l = stack.isEmpty()? 0: stack.lastElement() + 1;
                    areas[pop] = (i - l) * arr[pop];
                    max = Math.max(max, areas[pop]);
                }
            }
            stack.push(i);
        }

        int len = stack.size();
        for (int i = 0; i < len; i++) {
            int pop = stack.pop();
            areas[pop] = (arr.length - (stack.isEmpty() ? 0 : stack.lastElement() + 1)) * arr[pop];
            max = Math.max(max, areas[pop]);
        }
        System.out.println(Arrays.toString(areas));
        return max;
    }

    public static void main(String[] args) {
        int[] test = {3,6,5,7,4,8,1,0};
        System.out.println(largestRectangleArea(test));
    }
}
