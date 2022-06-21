package array;

public class SpiralOrderGenerateI{
    public int[][] spiralGenerate(int n) {
        // Write your solution here
        int m = 1;
        int[][] matrix = new int[n][n];
        int upBound = 0;
        int lowBound = n - 1;
        int leftBound = 0;
        int rightBound = n - 1;
        while(m <= n*n) {
            if(upBound <= lowBound) {
                for(int i = leftBound; i <= rightBound; i++) {
                    matrix[upBound][i] = m;
                    m++;
                }
                upBound++;
            }

            if(leftBound <= rightBound) {
                for(int i = upBound; i <= lowBound; i++) {
                    matrix[i][rightBound] = m;
                    m++;
                }
                rightBound--;
            }

            if(upBound <= lowBound) {
                for(int i = rightBound; i>= leftBound; i--) {
                    matrix[lowBound][i] = m;
                    m++;
                }
                lowBound--;
            }

            if(leftBound <= rightBound) {
                for(int i = lowBound; i >= upBound; i--) {
                    matrix[i][leftBound] = m;
                    m++;
                }
                leftBound++;
            }
            
        }
        return matrix;
      }
}