package binaryTree;

import pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if (cur == null) {
                flag = true;
                continue;
            }
            if (flag) {
                return false;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}
