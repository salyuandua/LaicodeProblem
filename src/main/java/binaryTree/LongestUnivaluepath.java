package binaryTree;

import pojo.TreeNode;

public class LongestUnivaluepath {
    public int longestUnivaluePath(TreeNode root) {
        // Write your solution here
        int[] max = new int[]{0};
        helper(root, max);
        return max[0];
      }

    
      private int helper(TreeNode root, int[] max) {
        if(root == null) return 0;
        int left = helper(root.left, max);
        int right = helper(root.left, max);
        if(root.left== null || root.key != root.left.key) {
            left = 0;
        }
        if(root.right == null || root.key != root.right.key) {
            right = 0;
        }

        max[0] = Math.max(max[0], left + right + 1);
        return Math.max(left, right) + 1;
      }
}
