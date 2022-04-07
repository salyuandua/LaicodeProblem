package DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KeepDistanceForIdenticalElements {

    int[] result = null;
    public int[] keepDistance(int k) {
        int[] kArray = new int[2 * k];
        int idx = 0;
        int k2 = 1;
        while (k2 <= k) {
            kArray[idx++] = k2;
            kArray[idx++] = k2;
            k2++;
        }
        helper(kArray, 0);
        return result;
    }

    private void helper(int[] k, int layer) {
        if (layer == k.length) {

            if (checkArray(k)) {
                if (result == null) {
                    result = new int[k.length];
                }
                for (int n = 0; n < k.length; n++) {
                    result[n] = k[n];
                }
            }
            return;
        }
        for (int i = layer; i < k.length; i++) {
            swap(k, i, layer);
            helper(k, layer + 1);
            swap(k, i, layer);
        }
    }

    private void swap(int[] k, int i, int j) {
        int temp = k[i];
        k[i] = k[j];
        k[j] = temp;
    }

    private boolean checkArray(int[] k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k.length; i++) {
            if (!map.containsKey(k[i])) {
                map.put(k[i], i);
                continue;
            }
            int idx = map.get(k[i]);
            if (Math.abs(idx - i) - 1 != k[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        KeepDistanceForIdenticalElements elements = new KeepDistanceForIdenticalElements();
        //elements.checkArray(new int[]{2, 3, 1, 2, 1, 3});
        System.out.println(Arrays.toString(elements.keepDistance(3)));
    }
}
