package binaryTree.BST.number;

import pojo.TreeNode;

public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        int[] result = new int[1];
        helper(root, k, result);
        return result[0];
    }

    private void helper(TreeNode root, int k, int[] result) {
        if (root == null) {
            return;
        }
        System.out.println("k:" + k);
        k--;
        helper(root.left, k, result);

        if (k == 0) {
            result[0] = root.key;
            return;
        }
        helper(root.right, k, result);
    }

}
