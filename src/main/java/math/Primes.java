package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primes {
    public List<Integer> primes(int target) {
        // Write your solution here
        List<Integer> ans = new ArrayList<>();
        if (target < 3) return ans;
        boolean[] count = new boolean[target + 1];
        Arrays.fill(count, true);
        count[0] = false;
        count[1] = false;
        for (int i = 2; i <= target; i++) {
            if (!count[i]) continue;
            ans.add(i);
            for (int j = i * i; j <= target; j+=i) {
                count[j] = false;
            }
        }
        return ans;
    }
}
