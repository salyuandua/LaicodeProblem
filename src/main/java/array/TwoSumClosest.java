package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumClosest {
    public List<Integer> closest(int[] array, int target) {
        Arrays.sort(array);
        int[] ans = new int[2];
        int left = 0;
        int right = array.length - 1;
        int dist = Integer.MAX_VALUE;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                dist = 0;
                ans[0] = array[left++];
                ans[1] = array[right--];
                continue;
            }
            if (dist > Math.abs(sum - target)) {
                dist = Math.abs(sum - target);
                ans[0] = array[left];
                ans[1] = array[right];
            }
            if (sum > target) {
                right--;
            }else {
                left++;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(ans[0], ans[1]);
        return result;
    }
}
