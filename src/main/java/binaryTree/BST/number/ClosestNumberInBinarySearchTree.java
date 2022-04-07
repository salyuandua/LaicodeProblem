package binaryTree.BST.number;

import pojo.TreeNode;

public class ClosestNumberInBinarySearchTree {
    public  int closest(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        int[] minDis = new int[]{Integer.MAX_VALUE};
        helper(root, target, result, minDis);
        return result[0];
    }

    private void helper(TreeNode root, int target, int[] result, int[] minDis) {
        if (root == null) {
            return;
        }
        if (Math.abs(root.key - target) < minDis[0]) {
            result[0] = root.key;
            minDis[0] = Math.abs(root.key - target);
        }
        if (target == root.key) {
            return;
        }else if (target < root.key) {
            helper(root.left, target, result, minDis);
        }else {
            helper(root.right, target, result, minDis);
        }
    }
}
