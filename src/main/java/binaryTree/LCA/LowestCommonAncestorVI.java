package binaryTree.LCA;

import pojo.KnaryTreeNode;
import pojo.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LowestCommonAncestorVI {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        // Write your solution here
        Set<KnaryTreeNode> set = new HashSet<>();
        for (KnaryTreeNode node : nodes) {
            set.add(node);
        }
        return helper(root, set);
    }

    private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }

        int count = 0;
        KnaryTreeNode node = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode childNode = helper(child, set);
            if (childNode != null) {
                count++;
                if (count == 2) {
                    return root;
                }
                node = childNode;
            }
        }
        return node;

    }
}
