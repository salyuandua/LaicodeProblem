package binaryTree;

import pojo.TreeNode;

public class ConnectRightPointerToSuccessor {
    public void connect(TreeNode root) {
        //helper(root, null);
        linkRightToSuccessor(root, null);
    }

    private void helper(TreeNode root, TreeNode prev) {
        if (root == null) {
            return ;
        }
        helper(root.left, root);
        if (root.right == null) {
            root.right = prev;
        }else {
            helper(root.right, root);
        }
        return ;
    }

    void linkRightToSuccessor(TreeNode root, TreeNode prev) {
        if(root==null) {
            return;
        }
        linkRightToSuccessor(root.right, prev);
        if(prev!=null && root.right==null) {
            root.right = prev;
        }
        prev = root;

        linkRightToSuccessor(root.left, prev);
    }
}
