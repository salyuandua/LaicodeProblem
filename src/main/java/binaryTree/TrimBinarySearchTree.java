package binaryTree;

import pojo.TreeNode;

public class TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int lower, int upper) {
        // Write your solution here
        return helper(root, lower, upper);

    }  

    private TreeNode helper(TreeNode root, int lower, int upper) {
        if(root == null) {
            return null;
        }
        root.left = helper(root.left, lower, upper);
        root.right = helper(root.right, lower, upper);

        if(root.key < lower) {
            return root.right;
        }else if(root.key > upper) {
            return root.left;
        }else {
            return root;
        }
    }
}
