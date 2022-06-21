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

    public List<Integer> spiral1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int upBound = 0;
        int lowBound = m - 1;
        int leftBound = 0;
        int rightBound = n - 1;
        while(res.size() < m * n) {
            if(upBound <= lowBound) {
                for(int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upBound][i]);
                }
                upBound++;
            }

            if(leftBound <= rightBound) {
                for(int i = upBound; i <= lowBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            if(upBound <= lowBound) {
                for(int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[lowBound][i]);
                }
                lowBound--;
            }

            if(leftBound <= rightBound) {
                for(int i = lowBound; i >= upBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }

            
        }
        return res;
    }



}
