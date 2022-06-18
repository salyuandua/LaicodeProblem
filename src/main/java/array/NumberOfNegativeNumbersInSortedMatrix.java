package array;

public class NumberOfNegativeNumbersInSortedMatrix {
    public int negNumber(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    result++;
                }else {
                    break;
                }
            }
        }
        return result;
    }
}
