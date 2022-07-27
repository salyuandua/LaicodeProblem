package heap;

import pojo.TreeNode;

public class DetermineIfBinaryTreeIsMinHeap {
    public boolean isMinHeap(TreeNode root) {
        int size = size(root);
        return helper(root, 0, size);
    }

    private boolean helper(TreeNode root, int idx, int size) {
        if(root == null) return true;
        if(idx >= size) return false;
        if ((root.left != null && root.left.key < root.key) 
                || (root.right != null && root.right.key < root.key)) {
            return false;
        }
        return helper(root.left, idx * 2 + 1, size) && helper(root.right, idx * 2 + 2, size);
    }

    private int size(TreeNode root) {
        if(root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }


}
