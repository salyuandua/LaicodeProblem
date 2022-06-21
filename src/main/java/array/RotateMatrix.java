package array;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i ++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = temp;
            }
        }
        for(int[] array : matrix) {
            swap(array);
        }
        
      }

    private void swap(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--; 
        }
    }  
}
