package JianZhi_55;

import java.util.Map;
import java.util.Stack;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 当初不会的题，现在直接秒的感觉太爽了
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}