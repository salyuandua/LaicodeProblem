package binaryTree.BST;

import pojo.TreeNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSuminBST {
    public boolean existSumBST(TreeNode root, int target) {
        // Write your solution here
        Set<Integer> set = new HashSet<>();
        return helper(root, target, set);
    }

    private boolean helper(TreeNode root, int target, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        int diff = target - root.key;
        if (set.contains(diff)) {
            return true;
        }
        set.add(root.key);
        return helper(root.left, target, set) || helper(root.right, target, set);
    }
}
