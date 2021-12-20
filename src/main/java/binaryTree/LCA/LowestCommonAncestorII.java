package binaryTree.LCA;

import pojo.TreeNodeP;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorII {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        Set<TreeNodeP> set = new HashSet<>();
        while (one != null) {
            set.add(one);
            one = one.parent;
        }
        while (two != null) {
            if (set.contains(two)) {
                return two;
            }
            two = two.parent;
        }
        return null;
    }
}
