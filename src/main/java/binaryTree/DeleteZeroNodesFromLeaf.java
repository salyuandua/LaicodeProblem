package binaryTree;

import pojo.TreeNode;

public class DeleteZeroNodesFromLeaf {
    public TreeNode deleteZero(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return null;
        }
        return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = helper(root.left);
        root.right = helper(root.right);
        if (root.key != 0) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}
