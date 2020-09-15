package ClassicCase.LinkedTable;

public class LTable {
    /** *************************
     *  创建各种链表
     ** ************************/
    // 正常的一个链表
    public static Node createLinkedList(int len) {
        Node head = new Node(1, null);
        Node p = head;
        for (int i = 2; i < len + 1; i++) {
            p.next = new Node(i, null);
            p = p.next;
        }
        return head;
    }

    // 有环的链表
    public static Node createLinkedList(int len, int r) {
        Node head = new Node(1, null);
        Node p = head;
        Node point = null;
        for (int i = 2; i < len + 1; i++) {
            p.next = new Node(i, null);
            p = p.next;
            if (i == r) {
                point = p;
            }
        }
        p.next = point;
        return head;
    }

    // 创建2个相交的链表
    public static Node[] createIntersectLinkedList(int len1, int len2, int intersectPoint){
        Node[] ans = new Node[]{new Node(1, null), new Node(10, null)};
        Node p1 = ans[0];
        Node p2 = ans[1];
        Node point = null;

        for (int i = 2; i <= 5; i++) {
            p1.next = new Node(i, null);
            p1 = p1.next;
            if (i == 3) point = p1;
        }

        for (int i = 1; i < 6; i++) {
            p2.next = new Node(10+i, point);
            p2 = p2.next;
        }
        return ans;
    }

    /** *************************
     *  链表的相关练习
     ** ************************/
    // 打印链表
    public static void print(Node head) throws InterruptedException {
        Node p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    // 翻转链表
    public static Node reverse(Node head){
        Node pre = null;
        Node curr = head;
        while(curr != null){
            Node currTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = currTemp;
        }
        return pre;
    }

    // 求链表的中间节点，使用快慢指针
    public static Node findMid(Node head){
        if (head == null || head.next == null) return head;
        Node slow = head;
        Node quick = head.next;
        while(quick != null && quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    // 判断链表是否有环
    public static int findLoop(Node head){
        if (head == null || head.next == null) return -1;
        Node slow = head;
        Node quick = head.next;

        while (quick.next != null && quick.next.next != null){
            slow = slow.next;
            quick = quick.next.next;
            if (slow == quick){
                // 进到这里来就说明相遇了，链表有环。
                // 让慢指针走一步，快指针回到头节点，且每次走一步，再次相遇时即环的入口
                quick = head;
                slow = slow.next;
                while (quick != slow){
                    quick = quick.next;
                    slow = slow.next;
                }
                return quick.val;
            }
        }
        return -1;
    }

    // 判断两个链表是否相交
    public static Node findIntersectPoint(Node head1, Node head2){
        Node p1 = head1, p2 = head2;
        int len1 = 1;
        int len2 = 1;
        while(p1.next != null) {
            len1++;
            p1 = p1.next;
        }
        while(p2.next != null) {
            len2++;
            p2 = p2.next;
        }

        // 尾结点相同，意味着有交点
        if (p1 == p2){
            p1 = head1;
            p2 = head2;
            if (len1 > len2){
                for (int i = 0; i < len1 - len2; i++) p1 = p1.next;
            }else if (len1 < len2) {
                for (int i = 0; i < len2 - len1; i++) p2 = p2.next;
            }
            while(p1!=null){
                if (p1 == p2) return p1;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        Node[] lists = createIntersectLinkedList(5, 10, 4);
        print(lists[0]);
        print(lists[1]);
        assert findIntersectPoint(lists[0], lists[1]) != null;
        System.out.println("交点为: " + findIntersectPoint(lists[0], lists[1]));

//        Node head = createLinkedList(5);
//        print(head);
//
//        Node r = reverse(head);
//        // 找链表的中间元素
////        System.out.println(findMid(head).val);
//
//        // 找链表的环入口
////        System.out.println(findLoop(head));
//
//        // 输出链表
//        print(r);
    }
}
