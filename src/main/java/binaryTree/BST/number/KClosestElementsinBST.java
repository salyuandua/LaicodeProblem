package binaryTree.BST.number;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KClosestElementsinBST {
    public List<Integer> kClosestBST(TreeNode root, int target, int k) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        helper(root, target, k, result);
        return result;
    }

    private void helper(TreeNode root, int target, int k, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, target, k, result);
        if (result.size() == k) {
            if (Math.abs(result.get(0) - target) > Math.abs(root.key - target)) {
                result.remove(0);
            }
        }
        result.add(root.key);
        helper(root.right, target, k, result);
    }
}
