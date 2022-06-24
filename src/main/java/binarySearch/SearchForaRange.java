package binarySearch;

public class SearchForaRange {
    public int[] range(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int leftBound = leftBound(array, target);
        if(leftBound == -1) return new int[]{-1, -1};
        int rightBound = rightBound(array, target);
        return new int[]{leftBound, rightBound};
    }

    private int leftBound(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == target) {
                right = mid - 1;
            }else if(array[mid] > target){
                right = mid - 1;
            }else if(array[mid] < target) {
                left = mid + 1;
            }
        }

        if(left >= array.length || array[left] == target) {
            return -1;
        }
        return left;
    }

    private int rightBound(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(array[mid] == target) {
                left = mid + 1;
            }else if(array[mid] > target){
                right = mid - 1;
            }else if(array[mid] < target) {
                left = mid + 1;
            }
        }

        if(right < 0 || array[right] == target) {
            return -1;
        }
        return right;
    }
    
}
