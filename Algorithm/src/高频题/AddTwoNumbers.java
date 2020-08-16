package 高频题;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isIn = false;
        int firNum, secNum, sum;

        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null || l2 != null){
            firNum = l1 == null? 0: l1.val;
            secNum = l2 == null? 0: l2.val;
            sum = firNum + secNum + (isIn? 1: 0);

            p.next = new ListNode(sum % 10);
            p = p.next;
            isIn = sum >= 10;
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }
        if (isIn){
            p.next = new ListNode(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {9, 9};
        ListNode l1 = new ListNode(a[0]);
        ListNode p1 = l1;
        for (int i = 1; i < a.length; i++) {
            p1.next = new ListNode(a[i]);
            p1 = p1.next;
        }
        ListNode l2 = new ListNode(b[0]);
        ListNode p2 = l2;
        for (int i = 1; i < b.length; i++) {
            p2.next = new ListNode(b[i]);
            p2 = p2.next;
        }

        ListNode ans = addTwoNumbers(l1, l2);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}
