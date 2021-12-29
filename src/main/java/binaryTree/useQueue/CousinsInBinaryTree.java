package binaryTree.useQueue;

import pojo.TreeNode;

public class CousinsInBinaryTree {
    public boolean isCousin(TreeNode root, int a, int b) {
        if (root == null) return false;
        int[] layers = new int[]{0,0};
        TreeNode[] parents = new TreeNode[2];
        helper(root,a,b,1, layers, parents);
        if (layers[0] != 0 && layers[1] != 0 && layers[0]==layers[1] && parents[0] != parents[1]) {
            return true;
        }
        return false;
    }

    private void helper(TreeNode root, int a, int b, int layer, int[] layers, TreeNode[] parents) {
        if (root == null) return;
        if (root.left!=null) {
            if (root.left.key == a) {
                layers[0] = layer + 1;
                parents[0] = root;
            }else if (root.left.key == b){
                layers[1] = layer + 1;
                parents[1] = root;
            } else {
                helper(root.left, a, b, layer + 1, layers, parents);
            }
        }
        if (root.right!=null) {
            if (root.right.key == a) {
                layers[0] = layer + 1;
                parents[0] = root;
            }else if (root.right.key == b){
                layers[1] = layer + 1;
                parents[1] = root;
            } else {
                helper(root.right, a, b, layer + 1, layers, parents);
            }
        }

    }
}
