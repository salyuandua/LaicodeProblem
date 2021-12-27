package binaryTree.rootToLeaf;

import pojo.TreeNode;

public class MaximumPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        if (root == null) {
            return max[0];
        }
        helper(root, 0, max);
        return max[0];
    }

    private void helper(TreeNode root, int curSum, int[] max) {
        if (root == null) {
            return;
        }
        if (curSum < 0) {
            curSum = root.key;
        }else {
            curSum += root.key;
        }
        max[0] = Math.max(max[0], curSum);
        helper(root.left, curSum, max);
        helper(root.right, curSum, max);
    }
}
