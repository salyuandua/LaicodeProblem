package binaryTree.useQueue;

import pojo.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<Integer> verticalOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        SortedMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(root, 0));
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Entry entry = queue.remove();
                if (!map.containsKey(entry.width)) {
                    map.put(entry.width, new ArrayList<>());
                }
                map.get(entry.width).add(entry.node.key);
                if (entry.node.left != null) {
                    queue.add(new Entry(entry.node.left, entry.width - 1));
                }

                if (entry.node.right != null) {
                    queue.add(new Entry(entry.node.right, entry.width + 1));
                }

            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            result.addAll(entry.getValue());
        }
        return result;
    }

    static class Entry {
        TreeNode node;
        int width;

        public Entry(TreeNode node, int width) {
            this.node = node;
            this.width = width;
        }
    }
}
