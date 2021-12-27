package binaryTree.leafToLeaf;

import pojo.TreeNode;

public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int[] min = new int[]{Integer.MAX_VALUE};
        helper(root, 0, min);
        return min[0];
    }

    private void helper(TreeNode root, int curDepth, int[] min) {
        if (root.left == null && root.right == null) {
            min[0] = Math.min(min[0], curDepth + 1);
            return;
        }
        curDepth++;
        if (root.left != null) {
            helper(root.left, curDepth, min);
        }
        if (root.right != null) {
            helper(root.right, curDepth, min);
        }
    }
}
