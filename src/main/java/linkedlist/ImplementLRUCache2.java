package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class ImplementLRUCache2<K, V> {

    private int limit;

    private Map<K, Node<K, V>> map = new HashMap<>();

    private CacheList<K, V> cacheList = new CacheList<>();


    public ImplementLRUCache2(int limit) {
        this.limit = limit;
    }

    public void set(K key, V value) {
        if (map.containsKey(key)) {
            Node<K, V> node = map.get(key);
            cacheList.remove(node);
            cacheList.addLast(node);
            return;
        }
        if (cacheList.size == limit) {
            Node<K, V> node = cacheList.removeFirst();
            map.remove(node.key);
        }
        Node<K, V> newNode = new Node<>(key, value);
        cacheList.addLast(newNode);
        map.put(key, newNode);
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        cacheList.remove(node);
        cacheList.addLast(node);
        return node.value;
    }

    static class CacheList <K, V>{
        int size;
        Node<K, V> head;
        Node<K, V> tail;

        public CacheList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        public void addLast(Node<K, V> newNode) {
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            size++;
        }

        public void remove(Node<K, V> node) {
            Node<K, V> prev = node.prev;
            Node<K, V> next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
            size--;
        }

        public Node<K, V> removeFirst() {
            if (size == 0) return null;
            Node<K, V> removedNode = head.next;
            head.next = removedNode.next;
            removedNode.next.prev = head;
            removedNode.prev = null;
            removedNode.next = null;
            size--;
            return removedNode;
        }

    }

    static class Node <K, V>{
        K key;
        V value;
        Node<K, V> next;
        Node<K, V> prev;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
