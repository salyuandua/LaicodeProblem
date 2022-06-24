package binarySearch;

public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        int m = matrix.length;
        if(m == 0) return new int[]{-1, -1};
        int n = matrix[0].length;
        int row = -1;
        
        for(int i = 0; i < m; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                row = i;
            }
        }
        if(row == -1) return new int[]{-1, -1};
        int col = binarySearch(matrix[row], target);
        if(col == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{row, col};
    }

    private int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == target) {
                return mid;
            }else if(array[mid] > target) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
    
}
