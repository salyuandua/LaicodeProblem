package binaryTree.useQueue;

import pojo.TreeNode;

import java.util.*;

public class GetKeysInBinaryTreeLayerByLayerZigZagOrder {
    public List<Integer> zigZag(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> localRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                localRes.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (layer % 2 == 1) {
                Collections.reverse(localRes);
            }
            result.addAll(localRes);
            layer++;
        }
        return result;
    }
}
