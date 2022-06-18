package array;

public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            int num = array[j];
            if (num == -1) {
                swap(array, i, j);
                i++;
                j++;
            }else if (num == 0) {
                j++;
            }else {
                swap(array, j, k);
                k--;
            }
        }
        return array;
    }
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
    }
}
