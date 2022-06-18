package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i-1]) continue;
            int j = i + 1;
            int k = array.length - 1;
            while (j < k) {
                int sum = array[i] + array[j] + array[k];
                if (sum == target) {
                    ans.add(Arrays.asList(array[i], array[j], array[k]));
                    j++;
                    k--;
                    while (j < k && array[j] == array[j - 1]) j++;
                    while (j < k && array[k] == array[k + 1]) k--;
                }else if(sum > target) {
                    k--;
                }else {
                    j++;
                }
            }
        }
        return ans;
    }
}
