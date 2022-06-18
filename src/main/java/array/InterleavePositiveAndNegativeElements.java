package array;

public class InterleavePositiveAndNegativeElements {
    public int[] interleave(int[] array) {
        // Write your solution here
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] < 0) {
                swap(array, slow, fast);
                slow++;
            }
        }

        int pos = slow;
        int neg = 0;
        while (pos < array.length && neg < pos && array[neg] < 0) {
            swap(array, neg, pos);
            neg +=2;
            pos ++;
        }
        return array;

    }

    public int[] interleave1(int[] arr) {
        int n = arr.length;
        // Write your solution here
        int i = -1, temp = 0;
        // 1. 先把负数放前
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int pos = i + 1, neg = 0;
        // 2. 把正数往前面负数群中交换
        while (pos < n && neg < pos && arr[neg] < 0) {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }
        return arr;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new InterleavePositiveAndNegativeElements().interleave1(new int[]{1, 2, 3, 4, 5, -1, -1, -1}));
    }
}

