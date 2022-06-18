package array;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZero(int[][] matrix) {
        // Write your solution here
        if (matrix.length == 0) return;
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroCols = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        for (int i = 0; i < zeroRows.length; i++) {
            if (zeroRows[i]) {
                nullifyRow(matrix, i);
            }
        }

        for (int i = 0; i < zeroCols.length; i++) {
            if (zeroCols[i]) {
                nullifyCol(matrix, i);
            }
        }
    }

    private void nullifyRow(int[][] mat, int row) {
        for (int i = 0; i < mat[0].length; i++) {
            mat[row][i] = 0;
        }
    }

    private void nullifyCol(int[][] mat, int col) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes zeroes = new SetMatrixZeroes();
        int[][] input = new int[][]{ {1, 1, 1, 1, 0},

                {0, 1, 1, 0, 1},

                {1, 1, 1, 0, 1},

                {1, 1, 1, 1, 1}};
        zeroes.setZero(input);
        System.out.println();
    }
}
