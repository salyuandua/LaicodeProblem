package binaryTree;

import pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InsertRowtoTree {
    public TreeNode insertRow(TreeNode root, int v, int d) {
        // Write your solution here
        if (root == null) {
            if (d == 1) {
                return new TreeNode(v);
            }else {
                return null;
            }
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (level + 1 == d) {
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);
                    left.left = cur.left;
                    right.right = cur.right;
                    cur.left = left;
                    cur.right = right;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            level ++;
        }
        return root;
    }

}
