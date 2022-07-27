package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FindKPairswithSmallestSums {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // write your code here
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            return Integer.compare(n1[2], n2[2]);
        });

        pq.offer(new int[]{0, 0, nums1[0] + nums2[0]});
        List<List<Integer>> res = new ArrayList<>();
        Set<String> visted = new HashSet<>();
        visted.add("0_0");
        for(int i = 1; i <= k; i++) {
            if(!pq.isEmpty()) {
                int[] cur = pq.poll();
                res.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));

                if(cur[0] + 1 < nums1.length && !visted.contains(String.valueOf(cur[0] + 1) + "_" + String.valueOf(cur[1]))) {
                    pq.offer(new int[]{cur[0] + 1, cur[1], nums1[cur[0] + 1] + nums2[cur[1]]});
                    visted.add(String.valueOf(cur[0] + 1) + "_" + String.valueOf(cur[1]));
                }

                if(cur[1] + 1 < nums2.length && !visted.contains(String.valueOf(cur[0]) + "_" + String.valueOf(cur[1] + 1))) {
                    pq.offer(new int[]{cur[0], cur[1] + 1, nums1[cur[0]] + nums2[cur[1] + 1]});
                    visted.add(String.valueOf(cur[0]) + "_" + String.valueOf(cur[1] + 1));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{-10,-4,0,0,6}, new int[]{3,5,6,7,8,100}, 10));
    }


}
