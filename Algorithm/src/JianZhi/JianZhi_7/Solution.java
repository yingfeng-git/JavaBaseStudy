package JianZhi.JianZhi_7;

import base.TreeNode;


/**
 * 题目给出的参数有先根遍历和中根遍历（树的所有元素都不重复，这个条件很重要，不然这个方法没法做）
 * 根据遍历规则：
 * 1. 先根遍历的结果的第一位肯定是树的根节点
 * 2. 在中根遍历中找到这个根节点，根节点的左边的所有元素为左子树的元素，右边所有元素为右子树的所有元素
 * 3. 当分别知道了左右子树的元素个数时，在先根遍历中就可以划分左右子树的元素范围。并且划分出两个部分的
 *    第一个元素分别为根节点的左右子节点
 * 4. 在递归的时候，需要找到先根遍历的开始、结束位置，中根遍历的开始、结束位置。然后当开始/结束位置开始
 *    重叠的时候就意味着递归的结束，返回null。
 * 优化的点：用LinkedList复制一份inorder，可以快速找到i的值
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0, preorder.length - 1,
                inorder, 0, preorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode tree = new TreeNode(preorder[preStart]);

        for (int i = inStart; i <= inEnd; i++) {
            if (preorder[preStart] == inorder[i]){
                tree.left = buildTree(preorder, preStart+1, i-inStart+preStart, inorder, inStart, i - 1);
                tree.right = buildTree(preorder, i-inStart+preStart+1, preEnd, inorder, i+1, inEnd);
            }
        }
        return tree;
    }
}
