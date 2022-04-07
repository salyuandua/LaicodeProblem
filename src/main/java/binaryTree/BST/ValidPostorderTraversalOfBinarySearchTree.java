package binaryTree.BST;
//https://github.com/xieqilu/Qilu-leetcode/blob/master/B206.ValidatePostorderTraversalBST.cs
public class ValidPostorderTraversalOfBinarySearchTree {
    public boolean validPostOrder(int[] post) {
        // Write your solution here
        return helper(post, 0, post.length -1);
    }

    private boolean helper(int[] post, int low, int high) {
        if (low >= high) {
            return true;
        }
        int root = post[high];
        int i = high - 1;
        while (i >= low && post[i] > root) {
            i--;
        }
        int mid = i;
        while (i >= low && post[i] < root) {
            i--;
        }
        if (i != low - 1) {
            return false;
        }
        return helper(post, low, mid) && helper(post, mid + 1, high);
    }
}
