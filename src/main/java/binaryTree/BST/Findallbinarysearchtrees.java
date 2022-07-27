package binaryTree.BST;

import java.util.ArrayList;
import java.util.List;

import pojo.TreeNode;

public class Findallbinarysearchtrees {
    public List<TreeNode> generateBSTs(int n) {
        //Input your code here
        return helper(1, n);
      }

    private List<TreeNode> helper(int start, int end) {
      List<TreeNode> res = new ArrayList<>();
      if(start > end) {
        res.add(null);
        return res;
      }
      for(int i = start; i <= end; i++) {
        List<TreeNode> left = helper(start, i - 1);
        List<TreeNode> right = helper(i + 1, end);
        for(TreeNode leftNode : left) {
          for(TreeNode rightNode : right) {
            TreeNode root = new TreeNode(i);
            root.left = leftNode;
            root.right = rightNode;
            res.add(root);
          }
        }
      }
      return res;
    }
}
