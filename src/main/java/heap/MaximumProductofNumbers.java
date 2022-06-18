package heap;

import java.util.Arrays;

public class MaximumProductofNumbers {
    public static int maxProduct(int[] nums) {
        // Write your solution here
        Arrays.sort(nums);

        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
                            nums[0] * nums[1] * nums[nums.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-35,13,30,-7,6,-33,-27,-85,-70,-96,-66,37,-15,-98,-94,35,92,90,86,-37,96,-94,-19,27,67,-47,73,25,-84,61,-32,-77,-44,43,40,97,-7,-39,-99,-7,47,-96,54,-69,81,-49,-14,20,44,85,-100,-24,59,-79,11,99,58,62,-96,-2,17,93,63,45,81,-66,2,-1,97,-8,24,12,-34,73,0,4,52,55,-15,3}));
    }
}
