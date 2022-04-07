package binaryTree.BST;

import pojo.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        // Write your solution here
        int left = leftHeight(root);
        int right = rightHeight(root);
        if (left == right) return (int) Math.pow(2, left - 1);
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private int leftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return leftHeight(root.left) + 1;
    }

    private int rightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return rightHeight(root.right) + 1;
    }
}
