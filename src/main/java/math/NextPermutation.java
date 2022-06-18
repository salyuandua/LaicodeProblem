package math;

public class NextPermutation {
    public int[] nextPermutation(int[] num) {
        // Write your solution here
        if (num == null || num.length == 0) return num;
        int i = num.length - 2;
        while (i >= 0 && num[i + 1] <= num[i]) {
            i--;
        }
        if (i >= 0 ) {
            int j = num.length - 1;
            while (j >= 0 && num[j] <= num[i]) {
                j--;
            }
            swap(num, i ,j);
        }
        reverse(num, i + 1, num.length - 1);
        return num;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(int[] num, int start, int end) {
        while (start < end) {
            swap(num, start, end);
            start++;
            end--;
        }
    }
}
