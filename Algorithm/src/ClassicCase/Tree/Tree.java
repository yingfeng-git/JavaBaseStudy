package ClassicCase.Tree;

import org.jetbrains.annotations.NotNull;

public class Tree {
    static int i = 0;

    public static TreeNode buildTree(String @NotNull [] s) {
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
     * 下面分别实现先根遍历，中跟遍历，后根遍历的递归版
     */
    public static void preorder(TreeNode tree) {

    }

    public static void inorder(TreeNode tree) {

    }

    public static void postorder(TreeNode tree) {

    }

    /**
     * 下面分别实现先根遍历，中跟遍历，后根遍历非递归版
     */
    public static void  recursionPreorder(TreeNode tree) {

    }

    public static void recursionInorder(TreeNode tree) {

    }

    public static void recursionPostorder(TreeNode tree) {
    }
}