package string.slidingWindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int num, int[] nums) {
        // Write your solution here
        int minSize = Integer.MAX_VALUE;
        int slow = 0;
        int sum = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (slow <= fast && sum >= num) {
                minSize = Math.min(minSize, fast - slow + 1);
                sum -= nums[slow];
                slow ++;

            }
        }
        return minSize == Integer.MIN_VALUE ? 0 : minSize;
    }
}
