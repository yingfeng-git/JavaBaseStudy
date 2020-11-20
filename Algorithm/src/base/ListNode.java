package base;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createNode(int[] arr) {
        ListNode head = new ListNode(arr[0], null);
        ListNode p = head;
        for (int i = 1; i < arr.length; i++) {
            p.next = new ListNode(arr[i], null);
            p = p.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        System.out.print("[ ");
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println("]");
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}
