package JianZhi_6;

import java.util.*;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //递归写法，最慢
    public static int[] reversePrint1(ListNode head) {
        if (head.next == null) {
            int[] a = new int[]{head.val};
            System.out.println(Arrays.toString(a));
            return a;
        } else {
            int[] res = reversePrint(head.next);
            int[] a = new int[res.length+1];
            System.arraycopy(res, 0, a, 0, res.length);
            a[a.length-1] = head.val;
            return a;
        }
    }

    // 第二个版本 用LinkedList来做，非递归，速度快很多但还是很慢，时间复杂度已经是N了，估计慢在LinkedList转int[]
    public static int[] reversePrint2(ListNode head) {
        List<Integer> res = new LinkedList<>();
        while (head != null){
            res.add(0, head.val);
            head = head.next;
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    // 第三个版本 非递归, 先遍历一次获取链表的长度，然后再放到数组里。空间复杂度是nlogn
    public static int[] reversePrint3(ListNode head) {
        int[] res = new int[0];
        while (head != null){
            int[] temp = new int[res.length+1];
            System.arraycopy(res, 0, temp, 1, res.length);
            temp[0] = head.val;
            res = temp;
            head = head.next;
        }
        return res;
    }

    // 第四个版本 借助题目上的条件 链表长度<=10000, 速度1ms
    public static int[] reversePrint(ListNode head) {
        int[] c = new int[10001];
        int length = 0;
        while (head != null){
            c[length++] = head.val;
            head = head.next;
        }

        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = c[length - i - 1];
        }
        return res;
    }

    public static int[] reversePrint4(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }

        int[] ans = new int[stack.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pop().val;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2};
        ListNode p = new ListNode(a[0]);
        ListNode head = p;
        for (int i = 1; i < a.length; i++) {
            p.next = new ListNode(a[i]);
            p = p.next;
        }

        System.out.println(Arrays.toString(reversePrint4(head)));

    }
}
