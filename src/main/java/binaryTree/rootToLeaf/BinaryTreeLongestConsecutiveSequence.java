package binaryTree.rootToLeaf;

import pojo.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        // Write your solution here
        if (root == null) {
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private Entry helper(TreeNode root, int[] max) {
        if (root == null) {
            return new Entry(0, Integer.MAX_VALUE);
        }
        Entry left = helper(root.left, max);
        Entry right = helper(root.right, max);
        int leftSize = 0;
        int rightSize = 0;
        if (root.key + 1 == left.key) {
            leftSize = left.size;
            max[0] = Math.max(max[0], left.size + 1);
        }
        if (root.key + 1 == right.key) {
            rightSize = right.size;
            max[0] = Math.max(max[0], right.size + 1);
        }
        return new Entry(leftSize > rightSize ? leftSize + 1 : rightSize + 1, root.key);
    }


    static class Entry {
        int size;
        int key;

        public Entry(int size, int key) {
            this.size = size;
            this.key = key;
        }
    }
}
