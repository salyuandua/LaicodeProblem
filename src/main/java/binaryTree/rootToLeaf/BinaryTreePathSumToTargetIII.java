package binaryTree.rootToLeaf;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSumToTargetIII {
    public boolean exist(TreeNode root, int target) {
        // Write your solution here
        List<TreeNode> path = new ArrayList<>();
        return helper(root, target, path);
    }

    private boolean helper(TreeNode root, int target, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).key;
            if (sum == target) {
                return true;
            }
        }
        boolean result = helper(root.left, target, path) || helper(root.right, target, path);
        path.remove(path.size() - 1);
        return result;
    }
}
