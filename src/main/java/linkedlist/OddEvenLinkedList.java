package linkedlist;

import pojo.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // Write your solution here
        if (head == null || head.next == null) return head;
        ListNode dummyHead = head;
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode evenCopy = dummyEven;
        int count = 1;
        while (head != null) {
            ListNode next = head.next;
            if (count % 2 == 0) {//even
                dummyEven.next = head;
                dummyEven = dummyEven.next;
                dummyEven.next = null;
            }else {
                dummyOdd.next = head;
                dummyOdd = dummyOdd.next;
                dummyOdd.next = null;
            }
            head = next;
            count++;
        }
        dummyOdd.next = evenCopy.next;
        return dummyHead;
    }
}
