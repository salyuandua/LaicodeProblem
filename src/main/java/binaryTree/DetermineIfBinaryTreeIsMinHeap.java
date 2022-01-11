package binaryTree;

import pojo.TreeNode;

public class DetermineIfBinaryTreeIsMinHeap {

    public boolean isMinHeap(TreeNode root) {
        if (root == null) {
            return false;
        }
        int size = size(root);
        return helper(root, 0, size);
    }

    private boolean helper(TreeNode root, int i, int size) {
        if (root == null) {
            return true;
        }
        if (i >= size) {
            return false;
        }
        if ((root.left != null && root.left.key >= root.key)
                || (root.right != null && root.right.key >= root.key)) {
            return false;
        }
        return helper(root.left, 2 * i + 1, size) && helper(root.right, 2 * i + 2, size);
    }

    private int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

}
