package binaryTree.BST;

import pojo.TreeNode;

public class SearchInBinarySearchTree {
    public TreeNode search(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.key) {
            return search(root.left, key);
        }else if (key > root.key) {
            return search(root.right, key);
        }else {
            return root;
        }
    }
}
