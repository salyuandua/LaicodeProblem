package heap;

public class HeapSort {
    public int[] heapsort(int[] array) {
        for(int i = array.length / 2; i >= 0; i--) {
            heapify(array, array.length, i);
        }
        for(int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        return array;

    }

    private void heapify(int[] array, int n,  int i) {
        int left = i * 2 + 1;
        int right = left + 1;
        int largestIdx = i;
        if(left < n && array[left] > array[largestIdx]) {
            largestIdx = left;
        }

        if(right < n && array[right] > array[largestIdx]) {
            largestIdx = right;
        }

        if(largestIdx != i) {
            int temp = array[i];
            array[i] = array[largestIdx];
            array[largestIdx] = temp; 
            heapify(array, n, largestIdx);
        }
    }
}
