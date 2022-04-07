package linkedlist;

import pojo.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your solution here
        List<ListNode> heads = new ArrayList<>();
        int flag = 0;
        ListNode cur = head;
        while (cur != null) {
            heads.add(cur);
            for (int i = 0; i < k-1; i++) {
                if (cur.next == null) {
                    flag = 1;
                    continue;
                }
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        for (int i = 0; i < heads.size(); i++) {
            if (i == heads.size() - 1 && flag == 1) continue;
            heads.set(i, reverse(heads.get(i)));
        }





    return null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
