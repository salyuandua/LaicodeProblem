package DFS;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> Restore(String ip) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        helper(ip, 0, "", res);
        return res;
    }

    private void helper(String ip, int idx, String cur, List<String> res) {
        if(idx >= 4 && ip.length() == 0) {
            res.add(cur.substring(1));
            return;
        }
        if(idx >= 4 || ip.length() == 0) return;

        helper(ip.substring(1), idx + 1, cur + "." + ip.substring(0, 1), res);
        if(ip.charAt(0) != '0' && ip.length() > 1) {
            helper(ip.substring(2), idx + 1, cur + "." + ip.substring(0, 2), res);
            if(ip.length() > 2 && Integer.getInteger(ip.substring(0, 3)) <= 255) {
                helper(ip.substring(3), idx + 1, cur + "." + ip.substring(0, 3), res);
            }
        }
    }

}
