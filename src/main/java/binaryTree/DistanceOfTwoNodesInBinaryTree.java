package binaryTree;

import pojo.TreeNode;

public class DistanceOfTwoNodesInBinaryTree {
    public int distance(TreeNode root, int n1, int n2) {
        TreeNode lca = findDistHelper(root, n1, n2);

        int d1 = findLevel(lca, n2, 0);
        int d2 = findLevel(lca, n1, 0);

        return d1+d2;
    }

    private int findLevel(TreeNode root, int k, int level) {
        if(root==null) {
            return -1;
        }
        if(root.key==k) {
            return level;
        }
        int l = findLevel(root.left, k, level+1);
        return (l!=-1) ? l : findLevel(root.right, k, level+1);
    }

    private TreeNode findDistHelper(TreeNode root, int n1, int n2) {
        if (root == null || root.key ==  n1 || root.key == n2) {
            return root;
        }
        TreeNode left_lca = findDistHelper(root.left, n1, n2);
        TreeNode right_lca = findDistHelper(root.right, n1, n2);
        if (left_lca !=null && right_lca !=null) {
            return root;
        }
        return (left_lca!=null) ? left_lca : right_lca;
    }
}
