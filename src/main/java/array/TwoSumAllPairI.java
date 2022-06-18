package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int diff = target - num;
            if (map.containsKey(diff)) {
                for (int diffIdx : map.get(diff)) {
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(diffIdx);
                    subAns.add(i);
                    ans.add(subAns);
                }
            }
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i);

        }
        return ans;
    }

    public List<List<Integer>> allPairs1(int[] array, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashmap.containsKey(target - array[i])) {
                List<Integer> list = hashmap.get(target - array[i]);
                for (int index : list) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(index);
                    pair.add(i);
                    ans.add(pair);
                }
            }
            if (hashmap.containsKey(array[i])) {
                hashmap.get(array[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashmap.put(array[i], list);
            }
        }
        return ans;
    }
}
