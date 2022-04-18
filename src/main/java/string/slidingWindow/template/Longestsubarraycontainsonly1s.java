package string.slidingWindow.template;

public class Longestsubarraycontainsonly1s {
    public int longestConsecutiveOnes(int[] nums, int k) {
        // Write your solution here
        if (nums == null || nums.length == 0) return 0;
        int maxLength = 0;
        int slow = 0;
        int counter = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] == 0) {
                counter++;
            }
            while (counter > k) {
                if (nums[slow] == 0) {
                    counter--;
                }
                slow++;
            }
            maxLength = Math.max(maxLength, fast - slow + 1);
        }
        return maxLength;
    }
}
