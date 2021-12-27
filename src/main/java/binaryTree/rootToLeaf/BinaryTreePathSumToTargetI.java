package binaryTree.rootToLeaf;

import pojo.TreeNode;

import java.util.HashSet;

public class BinaryTreePathSumToTargetI {
    public boolean exist(TreeNode root, int target) {
        return helper(root, target, 0);
    }

    private boolean helper(TreeNode root, int target, int curSum) {
        if (root == null) {
            return false;
        }
        curSum += root.key;
        if (root.left == null && root.right == null && curSum == target) {
            return true;
        }
        return helper(root.left, target, curSum) || helper(root.right, target, curSum);
    }
}
