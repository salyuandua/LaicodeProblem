package linkedlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ImplementLRUCache<K, V> {
    private int limit;
    private Map<K,ListEntry<K, V>> map = new HashMap<>();
    private ListEntry<K, V> head;
    private ListEntry<K, V> tail;
    private int size = 0;
    public ImplementLRUCache(int limit) {
        this.limit = limit;
    }

    public void set(K key, V value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            return;
        }
        if (size == 0) {
            head = new ListEntry<>(key, value);
            tail = head;
            map.put(key, head);
            size++;
        }else if (size == limit) {
            K oldKey = head.key;
            head.key = key;
            head.value = value;
            map.remove(oldKey);
            map.put(key, head);
        }else {
            ListEntry<K, V> newEntry = new ListEntry<>(key, value);
            head.prev = newEntry;
            newEntry.next = head;
            head = newEntry;
            map.put(key, head);
            size++;

        }
    }

    public V get(K key) {
        if (!map.containsKey(key) || size == 0) {
            return null;
        }
        ListEntry<K, V> cur = map.get(key);
        if (cur.key == tail.key) {
            return cur.value;
        }
        ListEntry<K,V> curNext = cur.next;
        ListEntry<K, V> curPrev = cur.prev;
        cur.next = null;
        tail.next = cur;
        cur.prev = tail;
        tail = cur;
        if (curPrev != null) {
            curPrev.next = curNext;
            curNext.prev = curPrev;
        }else {
            curNext.prev = null;
            head = curNext;
        }
        return cur.value;
    }

    private static class ListEntry<K, V> {
        K key;
         V value;
         ListEntry<K, V> prev;
         ListEntry<K, V> next;

        public ListEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ImplementLRUCache<String, String> cache = new ImplementLRUCache(3);
        cache.set("1", "1");
        cache.set("2","2");
        cache.set("3", "3");
        cache.get("3");
        cache.set("4", "4");
    }

}
