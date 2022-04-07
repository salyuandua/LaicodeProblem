package linkedlist;

import pojo.ListNode;

public class ReOrderLinkedList {
    public ListNode reorder(ListNode head) {
        // Write your solution here
        if(head == null) return null;
        ListNode mid = mid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);
        ListNode head1 = head;
        while (head1 != null && head2 != null) {
            ListNode head1Next = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = head1Next;
            head1 = head1Next;
        }
        return head;

    }

    private ListNode mid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode newHead = head;
        while (newHead != null) {
            ListNode next = newHead.next;
            newHead.next = prev;
            prev = newHead;
            newHead = next;
        }
        return prev;
    }
}
