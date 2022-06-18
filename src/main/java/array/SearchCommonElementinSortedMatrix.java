package array;

import java.util.Arrays;

public class SearchCommonElementinSortedMatrix {
    public int search(int[][] mat) {
        if (mat == null) return -1;
        if (mat.length == 0) return mat[0][0];
        for (int n : mat[0]) {
            boolean found = true;
            for (int i = 0; i < mat.length; i++) {
                if (Arrays.binarySearch(mat[i], n) < 0) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return n;
            }
        }
        return -1;
    }
}
