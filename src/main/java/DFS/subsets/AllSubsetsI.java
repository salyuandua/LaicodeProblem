package DFS.subsets;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsI {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return  res;
        }
        helper(set, 0, res, "");
        return res;
    }

    private void helper(String set, int layer, List<String> res, String curRes) {
        if (layer == set.length()) {
            res.add(curRes);
            return;
        }
        helper(set, layer + 1, res, curRes + set.charAt(layer));
        helper(set, layer + 1, res, curRes);
    }


}
