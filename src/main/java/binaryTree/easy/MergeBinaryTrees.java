package binaryTree.easy;

import pojo.TreeNode;

public class MergeBinaryTrees {
    public TreeNode mergeBinaryTrees(TreeNode root1, TreeNode root2) {
        // Write your solution here
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode newNode = new TreeNode(0);
        if (root1 != null && root2 != null) {
            newNode.key = root1.key + root2.key;
        } else {
            newNode.key = root1 == null ? root2.key : root1.key;
        }
        TreeNode root1Left = root1 == null ? null : root1.left;
        TreeNode root2Left = root2 == null ? null : root2.left;
        TreeNode root1Right = root1 == null ? null : root1.right;
        TreeNode root2Right = root2 == null ? null : root2.right;
        newNode.left = mergeBinaryTrees(root1Left, root2Left);
        newNode.right = mergeBinaryTrees(root1Right, root2Right);
        return newNode;
    }
}
