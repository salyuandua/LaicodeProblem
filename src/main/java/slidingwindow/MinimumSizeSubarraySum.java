package slidingwindow;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int num, int[] nums) {
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        while(right < nums.length) {
            sum+= nums[right];
            right++;
            while(sum >= num) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minLength == Integer.MIN_VALUE ? 0 : minLength;
    }
    
}
