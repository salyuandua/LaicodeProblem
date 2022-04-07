package binaryTree.rootToLeaf;

import pojo.TreeNode;

public class MaxPathSumFromLeafToRoot {
    public int maxPathSumLeafToRoot(TreeNode root) {
        // Write your solution here
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, 0, max);
        return max[0];
    }

    private void helper(TreeNode root, int curSum, int[] max) {
        if (root == null) {
            return;
        }
        curSum += root.key;
        if (root.left == null && root.right == null) {
            max[0] = Math.max(max[0], curSum);
        }
        helper(root.left, curSum, max);
        helper(root.right, curSum, max);
    }
}
