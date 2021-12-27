package binaryTree.leafToLeaf;

import pojo.TreeNode;

public class BinaryTreeDiameter {
    public int diameter(TreeNode root) {
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
        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], left + right + 1);
            return Math.max(left, right) + 1;
        }
        return root.left == null ? right + 1 : left + 1;
    }
}
