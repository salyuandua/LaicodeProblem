package array;

public class TrappingRainWater {
    public int trapWater(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        int peak_idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[peak_idx]) {
                peak_idx = i;
            }
        }
        int water = 0;
        int leftMostBar = 0;
        for (int i = 0; i < peak_idx; i++) {
            if (A[i] > A[leftMostBar]) {
                leftMostBar = A[i];
            }else {
                water+= (leftMostBar - A[i]);
            }
        }
        int rightMostBar = 0;
        for (int i = A.length - 1; i > peak_idx; i--) {
            if (A[i] > A[rightMostBar]) {
                rightMostBar = A[i];
            }else {
                water+= (rightMostBar - A[i]);
            }
        }

        return water;
    }
}
