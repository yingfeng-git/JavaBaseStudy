package JianZhi.JianZhi_32;

import base.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        int localLayer = 0;

        HashMap<TreeNode, Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int nodeLayer = map.get(node);
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, nodeLayer + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, nodeLayer + 1);
            }
            // 跳层了
            if (nodeLayer != localLayer){
                localLayer++;
                res.add(row);
                row = new LinkedList<>();
            }
            row.add(node.val);
        }
        res.add(row);
        return res;
    }
}
