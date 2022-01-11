package binaryTree;

import pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DetermineIfBinaryTreeIsFullTree {
    public boolean isFull(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return false;
        }
        return helper(root);
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            return helper(root.left) && helper(root.right);
        }
        return false;
    }
}
