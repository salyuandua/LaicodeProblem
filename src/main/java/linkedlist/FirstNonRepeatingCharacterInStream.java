package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInStream {

    private Map<Character, EntryNode> map = new HashMap<>();
    private EntryNode head;
    private EntryNode tail;

    public FirstNonRepeatingCharacterInStream() {
        // Initialize the class.
    }

    public void read(char ch) {
        // Implement this method here.
        if (!map.containsKey(ch)) {
            EntryNode newEntry = new EntryNode(ch);
            if (head == null) {
                head = newEntry;
                tail = head;
            }else {
                tail.next = newEntry;
                newEntry.prev = tail;
                tail = tail.next;
            }
            map.put(ch, newEntry);
            return;
        }
        EntryNode cur = map.get(ch);
        if (cur.deleted) return;
        cur.deleted = true;
        EntryNode prev = cur.prev;
        EntryNode next = cur.next;
        if (prev == null && next == null) {
            head = null;
            tail = null;
        }else if (prev == null) {
            head.next = null;
            head = next;
            head.prev = null;
        }else if (next == null){
            tail.prev = null;
            tail = prev;
            tail.next = null;
        }else {
            prev.next = next;
            next.prev = prev;
        }
       // map.remove(ch);
    }

    public Character firstNonRepeating() {
        // Implement this method here.
        if (head == null) return null;
        return head.c;
    }

    private static class EntryNode{
        char c;
        EntryNode next;
        EntryNode prev;
        boolean deleted;
        public EntryNode(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
        FirstNonRepeatingCharacterInStream stream = new FirstNonRepeatingCharacterInStream();
        stream.read('a');
        stream.read('b');
        stream.read('a');
        System.out.println(stream.firstNonRepeating());
    }
}
