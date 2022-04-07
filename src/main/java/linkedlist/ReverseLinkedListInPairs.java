package linkedlist;

import pojo.ListNode;

public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode dummp = new ListNode(0);
        ListNode cur = dummp;
        cur.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            cur.next = second;
            first.next = second.next;
            second.next = first;
            cur = cur.next.next;
        }
        return dummp.next;
    }
}
