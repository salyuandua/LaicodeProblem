package DP;

import pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        // Write your solution here
        if (root == null) return 0;
        Map<TreeNode ,Integer> map = new HashMap<>();
        return helper(root, map);
    }

    private int helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int money = root.key;
        if (root.left != null) {
            money += helper(root.left.left, map) + helper(root.left.right, map);
        }
        if (root.right != null) {
            money += helper(root.right.left, map) + helper(root.right.right, map);
        }
        int money2 = helper(root.left, map) + helper(root.right, map);
        return Math.max(money, money2);

    }
}
