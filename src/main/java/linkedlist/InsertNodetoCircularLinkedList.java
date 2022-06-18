package linkedlist;

import pojo.ListNode;

public class InsertNodetoCircularLinkedList {
    public ListNode insertCircularList(ListNode head, int newVal) {
        // write your solution here
        ListNode cur = head;
        while (cur.next != head && cur.value <= cur.next.value) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(newVal);
        ListNode startNode = cur.next;
        if (newVal > cur.value || newVal < cur.next.value) {
            cur.next = newNode;
            newNode.next = startNode;
            return head;
        }
        while (startNode != null) {
            if (newVal > startNode.value && newVal < startNode.next.value) {
                ListNode next = startNode.next;
                startNode.next = newNode;
                newNode.next = next;
                break;
            }
            startNode = startNode.next;
        }

        return head;
    }
}
