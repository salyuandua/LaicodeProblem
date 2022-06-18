package prefixSum;

public class RangeSumQuery {

    private int[] memo;

    public RangeSumQuery(int[] nums) {
        memo = new int[nums.length + 1];
        for (int i = 1; i < memo.length; i++) {
            memo[i] = memo[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return memo[j + 1] - memo[i];
    }
}
