package math;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public String[] summaryRanges(int[] nums) {
        // Write your solution here
        int left = 0;
        int right = 0;
        List<String> ans = new ArrayList<>();
        while (right < nums.length - 1) {
            if (nums[right + 1] - nums[right] == 1) {
                right++;
                continue;
            }
            String localAns = String.valueOf(nums[left]);
            if (left != right) {
                localAns = localAns + "->" + String.valueOf(nums[right]);
            }
            ans.add(localAns);
            right++;
            left = right;
        }
        if (left == nums.length - 1) {
            ans.add("" + nums[left]);
        }
        if (left != right) {
            ans.add(nums[left] + "->" + nums[nums.length - 1]);
        }
        String[] finalAns = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            finalAns[i] = ans.get(i);
        }
        return finalAns;
    }
}
