package array;

public class SubarraySumToTarget {
    public static boolean sumToTarget(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) return false;
        int slow = 0;
        int fast = 0;
        int sum = 0;
        while (fast < array.length) {
            sum += array[fast];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                fast++;
            }else {
                while (slow < fast && sum > target) {
                    sum -= array[slow];
                    if (sum == target) return true;
                    slow++;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sumToTarget(new int[]{1,2,4,8,16}, 0));
    }
}
