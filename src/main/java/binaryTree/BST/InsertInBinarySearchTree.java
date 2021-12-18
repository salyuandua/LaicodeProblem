package binaryTree.BST;

import pojo.TreeNode;

public class InsertInBinarySearchTree {
    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        }else {
            root.right = insert(root.right, key);
        }
        return root;
    }
}
