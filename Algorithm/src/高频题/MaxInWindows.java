package 高频题;

import java.util.*;

/**
 * 使用单调双端队列的解法，时间复杂度O(N)
 * @author yingfeng
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size){
        // 过滤异常情况
        if(size == 0 || size > num.length) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>(num.length - size + 1);
        Deque<Integer> queue = new LinkedList<>();

        // 窗口的左右下标
        int i = 0, j = 0;

        // 初始化窗口
        while(j < size){
            // j 右滑
            if(!queue.isEmpty()){
                while(num[queue.getLast()] <= num[j]){
                    queue.removeLast();
                    if(queue.isEmpty()) break;
                }
            }
            queue.add(j++);
        }
        // 初始化窗口完成，添加第一个窗口的最大值
        res.add(num[queue.getFirst()]);

        // 窗口开始滑动，尾巴先走
        while(j < num.length){
            // j 右滑
            // 在队列最右端比num[j]小的元素全部干掉，因为j左边的元素如果比j小已经没有意义了
            while(num[queue.getLast()] <= num[j]){
                queue.removeLast();
                // 如果队列被删空了直接跑路
                if(queue.isEmpty()) {
                    break;
                }
            }
            queue.add(j++);

            // i 右滑
            // 看一眼队列的头是否为刚从窗口左边掉出去的元素，如果是就在队列中删除
            if(i++ == queue.getFirst()) {
                queue.removeFirst();
            }

            // 队列中的第一个元素就是当前窗口的最大值的下标
            res.add(num[queue.getFirst()]);
        }
        return res;
    }
}