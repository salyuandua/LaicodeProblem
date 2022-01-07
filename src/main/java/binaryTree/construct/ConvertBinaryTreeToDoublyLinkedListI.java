package binaryTree.construct;

import pojo.TreeNode;

public class ConvertBinaryTreeToDoublyLinkedListI {

    private TreeNode head;
    private TreeNode prev;
    public TreeNode toDoubleLinkedList(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }
        helper(root);
        return head;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (prev == null) {
            head = root;
        }else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        helper(root.right);
    }
}
