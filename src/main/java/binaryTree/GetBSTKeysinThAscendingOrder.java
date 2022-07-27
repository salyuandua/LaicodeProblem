package binaryTree;

import java.util.ArrayList;
import java.util.List;

import pojo.TreeNode;

public class GetBSTKeysinThAscendingOrder {
    public List<Integer> getKeys(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.key);
        helper(root.right, res);
    }
}
