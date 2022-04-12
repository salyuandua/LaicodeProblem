package string.slidingWindow;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t <0 ) return false;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceil = treeSet.ceiling(nums[i]);
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t) {
                return true;
            }
            Integer floor = treeSet.floor(nums[i]);
            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t) {
                return true;
            }
            treeSet.add(nums[i]);
            if (i > k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
