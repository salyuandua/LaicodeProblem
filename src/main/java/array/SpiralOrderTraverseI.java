package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        helper(matrix, 0, matrix.length, ans);
        return ans;
    }

    private void helper(int[][] mat, int offset, int size, List<Integer> ans) {
        if (size <= 0) return;
        if (size == 1) {
            ans.add(mat[offset][offset]);
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            ans.add(mat[offset][offset + i]);
        }

        for (int i = 0; i  < size - 1; i++) {
            ans.add(mat[offset + i][offset + (size - 1)]);
        }

        for (int i = size - 1; i >=1; i--) {
            ans.add(mat[offset + (size - 1)][offset + i]);
        }

        for (int i = size - 1; i >=1; i--) {
            ans.add(mat[offset + i][offset]);
        }
        helper(mat, offset + 1, size + 2, ans);
    }
}
