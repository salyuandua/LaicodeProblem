package binaryTree.LCA;

import pojo.KnaryTreeNode;
import pojo.TreeNode;

public class LowestCommonAncestorV {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, KnaryTreeNode a, KnaryTreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }
        int count = 0;
        KnaryTreeNode temp = null;
        for (KnaryTreeNode child : root.children) {
            KnaryTreeNode childNode = lowestCommonAncestor(child, a, b);
            if (childNode != null) {
                count++;
                if (count == 2) {
                    return root;
                }
                temp = childNode;
            }
        }
        return temp;

    }
}
