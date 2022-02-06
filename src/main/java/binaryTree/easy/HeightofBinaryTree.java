package binaryTree.easy;

import pojo.TreeNode;

public class HeightofBinaryTree {
    public int getHeight(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return left > right ? left + 1 : right + 1;
    }
}
