package binaryTree.useQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import pojo.TreeNode;

public class InorderTraversalOfBinaryTreeIterative {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.key);
            cur = cur.right;
        }
        return result;
    }
}
