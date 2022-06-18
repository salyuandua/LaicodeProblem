package DP;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        // Write your solution here
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(rob1(nums1), rob1(nums2));
    }

    private int rob1(int[] nums) {
        int[] m = new int[nums.length + 1];
        m[0]  = 0;
        m[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            m[i] = Math.max(m[i - 1], nums[i - 1] + m[i - 2]);
        }
        return m[nums.length];
    }

    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(new int[]{11,12,5,8,3,10,5,7,13,8}));
    }
}
