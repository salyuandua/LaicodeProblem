package binaryTree;

import pojo.TreeNode;

public class MaximumPathSumBinaryTreeI {
    public int maxPathSum(TreeNode root) {
        if (root == null || root.left == null || root.right == null) {
            return Integer.MIN_VALUE;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (root.left!=null && root.right != null) {
            int curSum = root.key + left + right;
            max[0] = Math.max(max[0], curSum);
            return left > right ? left + root.key : right + root.key;
        }
        return root.left == null ? right + root.key : left + root.key;
    }

}
