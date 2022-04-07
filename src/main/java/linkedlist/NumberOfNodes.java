package linkedlist;

import pojo.ListNode;

public class NumberOfNodes {
    public int numberOfNodes(ListNode head) {
        // Write your solution here
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
