package binaryTree.BST;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ClosestNumberInBinarySearchTreeII {
    public int[] closestKValues(TreeNode root, double target, int k) {
        // Write your solution here
        if (root == null) return new int[]{0};
        List<Integer> res = new LinkedList<>();
        helper(root, target, k, res);
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void helper(TreeNode root, double target, int k, List<Integer> res) {
        if (root == null) return;
        helper(root.left, target, k, res);
        if (res.size() == k) {
            if (Math.abs(target - res.get(0)) > Math.abs(target - root.key)) {
                res.remove(0);
                res.add(root.key);
            }else {
                return;
            }

        }else {
            res.add(root.key);
        }
        helper(root.right, target, k, res);
    }


}
