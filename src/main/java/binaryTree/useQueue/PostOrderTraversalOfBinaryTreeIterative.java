package binaryTree.useQueue;

import pojo.TreeNode;

import java.util.*;

public class PostOrderTraversalOfBinaryTreeIterative {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        while (!deque.isEmpty()) {
            TreeNode cur = deque.pollFirst();
            result.add(cur.key);
            if (cur.left != null) {
                deque.offerFirst(cur.left);
            }
            if (cur.right != null) {
                deque.offerFirst(cur.right);
            }
        }
        Collections.reverse(result);
        return result;
    }
}
