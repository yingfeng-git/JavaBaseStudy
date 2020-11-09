package TrainingCamp01.SidleWindows;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 假设一个固定大小为W的窗口，依次划过arr，
 * 返回每一次滑出状况的最大值
 * 例如，arr = [4,3,5,4,3,3,6,7], W = 3
 * 返回：[5,5,5,4,6,7]
 * <p>
 * 右边界右滑：进来一个小的，往后面放。进来一个大的，把前面的小的都干掉
 * 左边界右滑：滑出去的元素是队列的头，remove。
 */
public class MaxInWindow {
    public static int[] windowsMax(int[] arr, int W) {
        Deque<Integer> deque = new LinkedList<>();
        int[] maxArr = new int[arr.length - W + 1];

        // 初始化，建立第一个窗口
        int max = 0;
        for (int i = 0; i < W; i++) max = Math.max(arr[i], max);
        maxArr[0] = max;
        deque.add(max);

        // 开始滑动
        for (int i = 1; i < maxArr.length; i++) {
            while (true) {
                if (deque.isEmpty() || arr[i + W - 1] <= deque.getLast()) {
                    deque.add(arr[i + W - 1]);
                    break;
                } else {
                    deque.removeLast();
                }
            }

            if (arr[i - 1] == deque.peek()) {
                deque.poll();
            }

            maxArr[i] = deque.peek();
        }

        return maxArr;
    }

    public static void main(String[] args) {
        int[] test = {4, 3, 5, 4, 4, 4, 3, 3, 6, 7};
        int W = 3;
        int[] ints = windowsMax(test, W);
        System.out.println(Arrays.toString(ints));
    }
}
