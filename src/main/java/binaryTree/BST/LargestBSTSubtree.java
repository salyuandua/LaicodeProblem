package binaryTree.BST;

import pojo.TreeNode;

public class LargestBSTSubtree {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }


    private Entry helper(TreeNode root, int[] max) {
        if (root == null) {
            return new Entry(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Entry left = helper(root.left, max);
        Entry right = helper(root.right, max);
        if (left.size > -1  && right.size > -1 && root.key > left.max && root.key < right.min) {
            max[0] = Math.max(max[0], left.size + right.size + 1);
            return new Entry(left.size + right.size + 1,
                    Math.min(left.min, root.key), Math.max(right.max, root.key));
        }
        return new Entry(-1, 0, 0);

    }

    static class Entry {
        int size;
        int min;
        int max;

        public Entry(int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
}
