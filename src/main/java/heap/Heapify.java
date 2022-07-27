package heap;

public class Heapify {
    public int[] heapify(int[] array) {
        // Write your solution here
        for(int i = array.length / 2; i < array.length; i++) {
            helper(array, i);
        }
        return array;

    }

    private void helper(int[] array, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largestIdx = i;
        if(left < array.length && array[left] > array[largestIdx]) {
            largestIdx = left;
        }
        if(right < array.length && array[right] > array[largestIdx]) {
            largestIdx = right;
        }

        if(largestIdx != i) {
            int temp = array[i];
            array[i] = array[largestIdx];
            array[largestIdx] = temp;
            helper(array, largestIdx);
        }

    }
}
