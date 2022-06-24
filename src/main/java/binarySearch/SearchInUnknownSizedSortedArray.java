package binarySearch;

public class SearchInUnknownSizedSortedArray {
    public int search(Dictionary dict, int target) {
        // Write your solution here
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left)/2;
            Integer midVal = dict.get(mid);
            if(midVal == null) {
                right = mid - 1;
                continue;
            }
            if(target == midVal) {
                return mid;
            }else if(target < midVal) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }

        return -1;
      }


        interface Dictionary {
            public Integer get(int index);
        }
}
