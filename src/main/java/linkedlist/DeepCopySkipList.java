package linkedlist;

import pojo.ListNode;
import pojo.SkipListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DeepCopySkipList {
    public SkipListNode copy(SkipListNode head) {
        if (head == null) {
            return null;
        }
        Map<SkipListNode, SkipListNode> map = new HashMap<>();
        SkipListNode newHead = new SkipListNode(head.value);
        SkipListNode result = newHead;
        map.put(head, newHead);
        while (head != null) {
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new SkipListNode(head.next.value));
                }
                newHead.next = map.get(head.next);
            }

            if (head.forward != null) {
                if (!map.containsKey(head.forward)) {
                    map.put(head.forward, new SkipListNode(head.forward.value));
                }
                newHead.forward = map.get(head.forward);
            }
            head = head.next;
            newHead = newHead.next;

        }
        return result;
    }
}
