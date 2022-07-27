package array.sort;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] array) {
        doSort(array, 0, array.length - 1);
    }

    private void doSort(int[] array, int left, int right) {
        if(left >= right) return;
        int p = partation(array, left, right);
        doSort(array, left, p - 1);
        doSort(array, p + 1, right);
    }

    private int partation(int[] array, int left, int right) {
        int i = left;
        int j = right - 1;
        int povit = array[right];
        while(true) {
            while(i <= j && array[i] <= povit) {
                i++;
            }
            while(i <= j && array[j] > povit) {
                j--;
            }
            if(i > j) break;
            swap(array, i, j);

        }

        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] input = new int[]{4,7,2,0,1,9,1};
        quickSort.sort(input);
        System.out.println(Arrays.toString(input));
    }
    
}
