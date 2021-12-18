package binaryTree.BST;

import pojo.TreeNode;

public class DeleteInBinarySearchTree {
    public TreeNode deleteTree(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = deleteTree(root.left, key);
        }else if(key > root.key) {
            root.right = deleteTree(root.right, key);
        }else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode min = findMin(root.right);
            root.key = min.key;
            root.right = deleteTree(root.right, min.key);

        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }


}
