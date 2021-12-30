package binaryTree.treeView;

import pojo.TreeNode;

import java.util.*;

public class TopViewOfBinaryTree {
    public List<Integer> topView(TreeNode root) {
        // Write your solution here
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Queue<Entry> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(new Entry(root, 0, true));
        while (!queue.isEmpty()) {
            Entry t = queue.remove();
            if (!set.contains(t.width)) {
                set.add(t.width);
                if (t.isLeft) {
                    result.addFirst(t.treeNode.key);
                }else {
                    result.addLast(t.treeNode.key);
                }
            }
            if (t.treeNode.left != null) {
                queue.add(new Entry(t.treeNode.left, t.width -1 , true));
            }
            if (t.treeNode.right != null) {
                queue.add(new Entry(t.treeNode.right, t.width + 1 , false));
            }

        }
        return result;
    }

    static class Entry {
        private TreeNode treeNode;
        private int width;
        private boolean isLeft;

        public Entry(TreeNode treeNode, int width, boolean isLeft) {
            this.treeNode = treeNode;
            this.width = width;
            this.isLeft = isLeft;
        }
    }


}
