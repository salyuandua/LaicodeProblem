package linkedlist;

import pojo.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Write your solution here
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        boolean flag = false;
        while (l1 != null && l2 != null) {
            int sum = l1.value + l2.value;
            if (flag) {
                sum ++;
                flag = false;
            }
            if (sum >=10) {
                sum = sum%10;
                flag = true;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode temp = l1 == null ? l2 : l1;
        while (temp != null) {
            int sum = temp.value;
            if (flag) {
                sum ++;
                flag = false;
            }
            if (sum >=10) {
                sum = sum%10;
                flag = true;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            temp = temp.next;
        }
        if (flag) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
