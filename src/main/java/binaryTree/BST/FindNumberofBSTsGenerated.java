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


    public static int numTrees(int n) {
        if (n < 2) return 1;
        int[] uniqueTrees = new int[n + 1];
        uniqueTrees[0] = 1;
        uniqueTrees[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.println("i : " + i + "j: " + j + "result:" + uniqueTrees[i - j]);
                uniqueTrees[i] += uniqueTrees[j - 1] * uniqueTrees[i - j];
            }
        }
        return uniqueTrees[n];
    }

    public static void main(String[] args) {
        numTrees(12);
    }
}
