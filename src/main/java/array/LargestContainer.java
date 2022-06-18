package array;

public class LargestContainer {
    public int largest(int[] array) {
        // Write your solution here
        if (array == null || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.min(area, Math.max(array[left], array[right]) * (right - left));
            if (array[left] > array[right]) {
                right--;
            }else {
                left++;
            }
        }
        return area;
    }

}
