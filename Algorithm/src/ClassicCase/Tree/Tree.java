package ClassicCase.Tree;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Tree {
    static int i = 0;

    public static TreeNode buildTree(String[] s) {
        if (i > s.length - 1 || s[i] == null) {
            i++;
            return null;
        }
        TreeNode head = new TreeNode(s[i], null, null);
        i++;

        head.left = buildTree(s);
        head.right = buildTree(s);
        return head;
    }

    /**
     * 二叉树递归时收集信息，Demo为计算树的层数
     */
    public static int maxLength(TreeNode head) {
        if (head == null) return 0;
        int max = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        HashMap<TreeNode, Integer> whereIsNode = new HashMap<>();
        whereIsNode.put(head, 1);
        while(!queue.isEmpty()){
            head = queue.pop();
            int layer = whereIsNode.get(head);

        }

        return max;
    }

    /**
     * 二叉树递归时收集信息，Demo为计算树的层数
     */
    public static Info searchInfoByTree(TreeNode head) {
        if (head == null) return new Info(0);
        Info i1 = searchInfoByTree(head.left);
        Info i2 = searchInfoByTree(head.right);
        return new Info(Math.max(i1.height, i2.height) + 1);
    }

    /**
     * 下面分别实现先根遍历，中跟遍历，后根遍历的递归版
     */
    public static void preorder(TreeNode tree) {
        if (tree == null) return;
        System.out.print(tree.val + " ");
        preorder(tree.left);
        preorder(tree.right);
    }

    public static void inorder(TreeNode tree) {
        if (tree == null) return;
        inorder(tree.left);
        System.out.print(tree.val + " ");
        inorder(tree.right);
    }

    public static void postorder(TreeNode tree) {
        if (tree == null) return;
        postorder(tree.left);
        postorder(tree.right);
        System.out.print(tree.val + " ");
    }

    /**
     * 下面分别实现先根遍历，中跟遍历，后根遍历非递归版
     */
    public static void unRecursionPreorder(TreeNode head) {
        if (head == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val + " ");

            // 先放右节点再放左节点！！！
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    public static void unRecursionInorder(TreeNode head) {
        if (head == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.print(head.val + " ");
                head = head.right;
            }
        }
    }

    public static void unRecursionPostorder(TreeNode head) {
        if (head == null) return;
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            head = stack1.pop();
            stack2.push(head);
            if (head.left != null) {
                stack1.push(head.left);
            }

            if (head.right != null) {
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()) System.out.print(stack2.pop().val + " ");
    }

    public static void row(TreeNode head) {
        if (head == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            System.out.print(head.val + " ");
            if (head.left != null) queue.add(head.left);
            if (head.right != null) queue.add(head.right);
        }
    }
}