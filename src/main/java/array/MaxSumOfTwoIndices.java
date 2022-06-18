package array;

public class MaxSumOfTwoIndices {
    public int[] maxSum(int[] array) {
        // Write your solution here
        int left = 0;
        int right = array.length - 1;
        int max = Integer.MIN_VALUE;
        int[] result = new int[2];
        while (left <= right) {
            if (array[left] + array[right] + (right - left) > max) {
                result[0] = left;
                result[1] = right;
                max = array[left] + array[right] + (right - left);
            }
            if (array[left] > array[right]) {
                right--;
            }else {
                left++;
            }
        }
        return result;
    }
}
