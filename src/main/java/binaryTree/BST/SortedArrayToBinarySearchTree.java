package binaryTree.BST;

import pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        // Write your solution here
        if (num == null || num.length == 0) {
            return null;
        }
       return helper(num, 0, num.length - 1);

    }

    private TreeNode helper(int[] num, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new TreeNode(num[low]);
        }
        int mid = low + (high - low) / 2;
        TreeNode cur = new TreeNode(num[mid]);
        cur.left = helper(num, low, mid - 1);
        cur.right = helper(num, mid + 1, high);
        return cur;
    }
}
