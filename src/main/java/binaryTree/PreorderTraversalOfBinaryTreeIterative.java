package binaryTree;

import pojo.TreeNode;

import java.util.*;

public class PreorderTraversalOfBinaryTreeIterative {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();
            result.add(cur.key);
            if (cur.right != null) {
                deque.offerFirst(cur.right);
            }
            if (cur.left != null){
                deque.offerFirst(cur.left);
            }
        }
        return result;
    }
}
