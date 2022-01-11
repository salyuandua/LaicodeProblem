package binaryTree;

import pojo.TreeNode;

import java.util.*;

public class DiagonalSumofaBinaryTree {
    public List<Integer> diagonalSum(TreeNode root) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        SortedMap<Integer, Integer> map = new TreeMap<>();
        helper(root, 0, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private void helper(TreeNode root, int diag, SortedMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(diag, map.getOrDefault(diag, 0) + root.key);
        helper(root.left, diag + 1, map);
        helper(root.right, diag, map);
    }
}
