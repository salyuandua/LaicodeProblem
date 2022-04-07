package DFS.permuation;

public class TwoSubsetsWithMinDifference {
    public int minDifference(int[] array) {
        // Write your solution here
        int totalSum = 0;
        for (int n : array) {
            totalSum += n;
        }
        int[] min = new int[]{Integer.MAX_VALUE};
        helper(array, 0, 0, min, totalSum, array.length/2);
        return min[0];
    }

    private void helper(int[] array, int layer, int sum1, int[] min, int totalSum, int count) {
        if (count==0) {
            int sum2 = totalSum - sum1;
            min[0] = Math.min(min[0], Math.abs(sum1 - sum2));
            return;
        }
        System.out.println(layer);
        for (int i = layer; i < array.length; i++) {
            sum1 += array[i];
            helper(array, layer+1, sum1, min, totalSum, count-1);
        }
    }

    public static void main(String[] args) {
        TwoSubsetsWithMinDifference subsets = new TwoSubsetsWithMinDifference();
        System.out.println(subsets.minDifference(new int[]{3,8,0,0,0,0}));;
    }
}
