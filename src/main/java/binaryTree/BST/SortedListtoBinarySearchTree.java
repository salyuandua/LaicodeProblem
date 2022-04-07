package binaryTree.BST;

import pojo.ListNode;
import pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SortedListtoBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        // Write your solution here
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        return helper(list, 0, list.size() - 1);
    }

    private TreeNode helper(List<Integer> list, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode cur = new TreeNode(list.get(mid));
        cur.left = helper(list, low, mid - 1);
        cur.right = helper(list, mid + 1, high);
        return cur;
    }
}
