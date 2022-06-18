package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left > 0 && left < right && array[left] == array[left - 1] ) {
                left++;
            }
            if (left >= right) {
                break;
            }
            int sum = array[left] + array[right];
            if (sum == target) {
                List<Integer> subAns = new ArrayList<>();
                subAns.add(array[left++]);
                subAns.add(array[right--]);
                ans.add(subAns);
            }else if (sum > target) {
                right--;
            }else {
                left++;
            }
        }
        return ans;
    }
}
