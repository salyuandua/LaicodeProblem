package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionofTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Write your solution here
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] < nums2[j]) {
                i++;
            }else {
                j++;
            }
        }
        int[] finalResult = new int[result.size()];
        for (int idx = 0; idx < finalResult.length; idx++) {
            finalResult[idx] = result.get(idx);
        }
        return finalResult;
    }
}
