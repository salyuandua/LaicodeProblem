package linkedlist;

import pojo.ListNode;

public class GenerateLinkedList {
    public ListNode generate(int n) {
        // Write your solution here
        ListNode head = null;
        ListNode result = null;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                head = new ListNode(i);
                result = head;
                continue;
            }
            head.next = new ListNode(i);
            head = head.next;
        }
        return result;
    }
}
