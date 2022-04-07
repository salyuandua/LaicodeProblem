package linkedlist;

import pojo.ListNode;

public class RemoveExtraDuplicatesfromSortedList {
    public ListNode removeDup1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null) {
            if (fast.value == slow.value) {
                while (fast != null && fast.value == slow.value) {
                    fast = fast.next;
                }
                slow.next = fast;
            }
            if (fast != null) {
                fast = fast.next;
            }

            slow = slow.next;
        }
        return head;
    }

    public ListNode removeDup2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.value != cur.next.next.value) {
                cur = cur.next;
                continue;
            }
            int val = cur.next.value;
            while (cur.next != null && val == cur.next.value) {
                cur.next = cur.next.next;
            }
        }
        return dummyHead.next;
    }
}
