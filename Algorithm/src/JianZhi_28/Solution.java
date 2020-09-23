package JianZhi_28;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return match(A, B);
    }

    public static boolean match(TreeNode A, TreeNode B) {
        if (B == null && A == null) {
            return true;
        } else if (A == null || A.val != B.val) {
            return false;
        }
        return match(A.left, B.left) && match(A.right, B.right);

    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSameTree(root.left, mirrorTree(root.right));
    }
}
