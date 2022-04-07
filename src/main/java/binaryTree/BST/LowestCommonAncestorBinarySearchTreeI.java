package binaryTree.BST;

import pojo.TreeNode;

public class LowestCommonAncestorBinarySearchTreeI {
    public TreeNode lca(TreeNode root, int p, int q) {
        // Write your solution here
        if (root == null || root.key == p || root.key == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
