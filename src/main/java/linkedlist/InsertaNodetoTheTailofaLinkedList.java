package linkedlist;

import pojo.ListNode;

public class InsertaNodetoTheTailofaLinkedList {
    public ListNode insertNode(ListNode head, int target) {
        // Write your solution here
        if (head == null) {
            return new ListNode(target);
        }
        ListNode result = head;
        while (head.next!=null) {
            head = head.next;
        }
        head.next = new ListNode(target);
        return result;
    }
}
