package linkedlist;

import pojo.ListNode;

public class MergeSortLinkedList {
    public ListNode mergeSort(ListNode head) {
        // Write your solution here
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(midNext);
        return merge(left, right);

    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(left != null && right != null) {
            if(left.value > right.value) {
                cur.next = right;
                right = right.next;
            }else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        if(left != null) {
            cur.next = left;
        }
        if(right != null) {
            cur.next = right;
        }
        return dummy.next;
    }
}
