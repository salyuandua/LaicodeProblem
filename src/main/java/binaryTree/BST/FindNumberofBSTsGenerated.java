package binaryTree.BST;

public class FindNumberofBSTsGenerated {
    public int numOfTrees(int n) {
        // Write your solution here
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += numOfTrees(i) * numOfTrees(n - 1 - i);
        }
        return res;
    }
}
