package string.slidingWindow;

public class SubarraywithMaximumAverageValue {
    public double maxAverage(int[] nums, int k) {
        // Write your solution here
        if (nums == null) return 0;
        if (k > nums.length) return getAverage(nums, 0, nums.length - 1);
        int left = 0;
        int right = k - 1;
        double max = Integer.MIN_VALUE;
        while (right < nums.length) {
            double average = getAverage(nums, left, right);
            max = Math.max(max, average);
            left++;
            right++;
        }
        return max;
    }

    private double getAverage(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum / (double)(end - start + 1);
    }

    public static void main(String[] args) {
        SubarraywithMaximumAverageValue value = new SubarraywithMaximumAverageValue();
        System.out.println(value.maxAverage(new int[]{-59,-59,-59,8,-46,2,3,93,-76,-77,37,-53,-53,-52,-52,-20,7,7,26,26,25,43,-94,19,19,64,64,63,19,34,-82,-81,-5,-6,47,34,35,35,57,-23,89,-19,-19,-20,-21,91,-22,-46,-46,-46,-46,-46,-46,-56,-55,-55,82,-56,-52,-53,-52,-53,-54,75,75,-82,67,-58,-57,-56,-55,-56,-56,-96,-95,-94,-75,-75,17,46,47,16,15,-28,-28,-28,-28,-28,-9}, 68));
    }
}
