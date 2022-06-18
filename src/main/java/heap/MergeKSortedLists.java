package heap;

import pojo.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here/.
        PriorityQueue<Entry> pq = new PriorityQueue<>();
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (ListNode node : listOfLists) {
            pq.offer(new Entry(node));
        }
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll().node;
            if (cur.next != null) {
                pq.offer(new Entry(cur.next));
            }
            head.next = cur;
            head = head.next;
        }
        return dummy.next;
    }

    static class Entry implements Comparable<Entry> {
        ListNode node;

        public Entry(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(node.value, o.node.value);
        }
    }
}
