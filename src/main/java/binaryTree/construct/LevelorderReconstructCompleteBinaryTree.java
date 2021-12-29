package binaryTree.construct;

import pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelorderReconstructCompleteBinaryTree {
    public TreeNode construct(int[] level) {
        // Write your solution here
        if (level.length==0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(level[0]);
        queue.add(root);
        int pointer = 1;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.remove();
                if (pointer< level.length) {
                    TreeNode left = new TreeNode(level[pointer++]);
                    cur.left = left;
                    queue.add(left);
                }
                if (pointer< level.length) {
                    TreeNode right = new TreeNode(level[pointer++]);
                    cur.right = right;
                    queue.add(right);
                }
            }
        }
        return root;
    }


}
