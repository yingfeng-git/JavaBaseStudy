package Leetcode.LC147;

import base.ListNode;

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode pre = head;
        ListNode temp = pre.next;
        while(temp != null){
            if(temp.val < pre.val){
                // 拿出来的值比前一个小，从头开始遍历，直到合适的位置插入
                // 1. 先把temp拿出来
                pre.next = pre.next.next;

                // 2. 找到temp的位置并插入，分两种情况
                ListNode p = cur;
                ListNode ltemp = temp.next;
                if(temp.val < p.val){
                    // temp比head小，让temp成为头
                    temp.next = cur;
                    cur = temp;

                }else{
                    // 遍历链表，会找到一个节点的val比temp的val小且该节点next的val比temp大
                    while(temp.val > p.val && temp.val > p.next.val) p = p.next;
                    temp.next = p.next;
                    p.next = temp;
                }
                temp = ltemp;

            } else{
                // 拿出来的值比前一个大, 不用调整，直接往后走
                pre = pre.next;
                temp = temp.next;
            }
//            ListNode.printList(cur);
        }
        return cur;
    }


    public static void main(String[] args) {
        int[] testcase = {4, 2, 1, 3};

        ListNode head = ListNode.createNode(testcase);
        ListNode.printList(head);

        Solution s = new Solution();
        ListNode.printList(s.insertionSortList(head));
    }
}
