package binaryTree.LCA;

import pojo.TreeNode;

public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode one, TreeNode two) {

        TreeNode result = helper(root, one, two);
        if (result == null) {
            return null;
        }else if (result != one && result != two) {
            return result;
        }else {
            if (result == one) {
                return helper(root, two, two) == null ? null : result;
            }else {
                return helper(root, one, one) == null ? null : result;
            }
        }

    }

    private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = helper(root.left, one, two);
        TreeNode right = helper(root.right, one, two);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
