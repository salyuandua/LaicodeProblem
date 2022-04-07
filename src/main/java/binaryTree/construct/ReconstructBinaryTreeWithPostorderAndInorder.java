package binaryTree.construct;

import pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructBinaryTreeWithPostorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        // Write your solution here
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inorderMap.put(inOrder[i], i);
        }
        return helper(postOrder, inorderMap, postOrder.length - 1,0, inOrder.length - 1);

    }

    private TreeNode helper(int[] postOrder, Map<Integer, Integer> inorderMap, int postOrderIdx,
                            int inorderStart, int inorderEnd) {
        if (postOrderIdx < 0 || inorderStart > inorderEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postOrder[postOrderIdx]);
        int inorderIdx = inorderMap.get(postOrder[postOrderIdx]);
        node.left = helper(postOrder, inorderMap, postOrderIdx - (inorderEnd - inorderIdx) - 1, inorderStart, inorderIdx - 1);
        node.right = helper(postOrder, inorderMap, postOrderIdx - 1, inorderIdx + 1, inorderEnd);
        return node;
    }
}
