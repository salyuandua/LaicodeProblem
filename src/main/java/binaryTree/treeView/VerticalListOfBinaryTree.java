package binaryTree.treeView;

import pojo.TreeNode;

import java.util.*;

public class VerticalListOfBinaryTree {
    public List<List<Integer>> verticalPrint(TreeNode root) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        SortedMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(new Entry(root, 0));
        while (!queue.isEmpty()) {
            Entry entry = queue.remove();
            if (!map.containsKey(entry.width)) {
                map.put(entry.width, new ArrayList<>());
            }
            map.get(entry.width).add(entry.node.key);

            if (entry.node.left != null) {
                queue.offer(new Entry(entry.node.left, entry.width - 1));
            }

            if (entry.node.right != null) {
                queue.offer(new Entry(entry.node.right, entry.width + 1));
            }
        }
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }

    static class Entry {
        private TreeNode node;
        private int width;

        public Entry(TreeNode node, int width) {
            this.node = node;
            this.width = width;
        }
    }
}
