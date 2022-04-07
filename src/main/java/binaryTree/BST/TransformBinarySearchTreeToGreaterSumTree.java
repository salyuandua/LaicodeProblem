package binaryTree.BST;

import pojo.TreeNode;

public class TransformBinarySearchTreeToGreaterSumTree {
    public TreeNode greaterSum(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return null;
        }
        int[] sum = new int[1];
        helper(root, sum);
        return root;
    }

    private void helper(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }
        helper(root.right, sum);
        int oldKey = root.key;
        root.key = sum[0];
        sum[0] += oldKey;
        helper(root.left, sum);
    }
}
