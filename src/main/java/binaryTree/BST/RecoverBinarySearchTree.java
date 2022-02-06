package binaryTree.BST;

import pojo.TreeNode;

public class RecoverBinarySearchTree {

    private TreeNode prev;
    private TreeNode first;
    private TreeNode second;

    public TreeNode recover(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        int temp = first.key;
        first.key = second.key;
        second.key = temp;
        return root;

    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev != null) {
            if (first == null && prev.key > root.key) {
                first = prev;
            }
            if (first != null && prev.key > root.key) {
                second = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}
