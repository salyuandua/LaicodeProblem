package binaryTree;

import pojo.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreetoString {
    public String flattenBinaryTree(TreeNode root) {
        // Write your solution here
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        }
        Stack<Character> stack = new Stack<>();
        result.append(root.key);
        helper(root.left, stack, result);
        helper(root.right, stack,result);
        return result.toString();
    }

    private void helper(TreeNode root, Stack<Character> stack, StringBuilder result) {
        if (root == null) {
            result.append("()");
            return;
        }
        result.append("(" + root.key);
        stack.push(')');
        if (root.left == null && root.right == null) {
            while (!stack.isEmpty()){
                result.append(stack.pop());
            }
            return;
        }

        helper(root.left, stack, result);
        if (root.right != null) {
            helper(root.right, stack, result);
        }

    }

}
