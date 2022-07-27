package binaryTree;

import pojo.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // Write your solution here
        return helper(nums, 0, nums.length - 1);
      }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int maxIdx = left;
        for(int i = left; i <= right; i++) {
            if(nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        TreeNode newNode = new TreeNode(nums[maxIdx]);
        newNode.left = helper(nums, left, maxIdx - 1);
        newNode.right = helper(nums, maxIdx + 1, right);
        return newNode;
    }
}
