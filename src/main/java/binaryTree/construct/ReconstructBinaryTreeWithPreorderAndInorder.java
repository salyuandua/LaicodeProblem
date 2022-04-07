package binaryTree.construct;

import pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPreorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        // Write your solution here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        return helper(preOrder, 0, 0, inOrder.length - 1, map);
    }

    private TreeNode helper(int[] preOrder, int preOrderStart,
                            int inOrderStart, int inOrderEnd,
                            Map<Integer, Integer> map) {
        if (preOrderStart >= preOrder.length || inOrderStart > inOrderEnd) return null;
        TreeNode root = new TreeNode(preOrder[preOrderStart]);
        int inOrderIdx = map.get(preOrder[preOrderStart]);
        root.left = helper(preOrder, preOrderStart + 1, inOrderStart, inOrderIdx - 1, map);
        root.right = helper( preOrder, preOrderStart + inOrderIdx - inOrderStart + 1, inOrderIdx +1, inOrderEnd, map);
        return root;
    }
}
