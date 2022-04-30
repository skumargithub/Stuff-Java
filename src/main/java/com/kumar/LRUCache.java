package com.kumar;

import java.lang.reflect.Constructor;
import java.util.*;

class Node<K, V> {
    public K k;
    public V v;

    Node next = null;
    Node prev = null;

    Node(K k, V v) {
        this.k = k;
        this.v = v;
    }

    Node(Node n) {
        this.k = (K) n.k;
        this.v = (V) n.v;
    }
}

public class LRUCache<K, V> {
    private Map<K, Node<K, V>> cache = new HashMap<>();
    private Node<K, V> first = null;
    private Node<K, V> last = null;
    private int maxSize = 0;

    LRUCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("first: (" + first.k + ", " + first.v + ")\n");
        sb.append("last: (" + last.k + ", " + last.v + ")\n");
        for(Node n = first; n != null; n = n.next) {
            sb.append("(" + n.k + ", " + n.v + ") -> ");
        }
        sb.append("null");

        return sb.toString();
    }

    public Node first() {
        return first;
    }

    public Node last() {
        return last;
    }

    private void evictOldest() {
        if(last == null) return;

        Node toEvict = last;
        cache.remove(toEvict);

        last = last.prev;
        if(last == null) first = null;
    }

    // Move Node n to the front of the doubly linked list
    public void touch(K k) {
        if(k == null) return;

        Node kv = cache.get(k);
        if(kv == null) return;

        if(kv.prev != null) kv.prev.next = kv.next;
        if(kv.next != null) kv.next.prev = kv.prev;

        kv.prev = null;
        kv.next = first;

        first = kv;
    }

    public void insert(K k, V v) {
        if(cache.containsKey(k)) {
            touch(k);
        } else {
            if(cache.size() >= this.maxSize) {
                evictOldest();
            }

            Node<K, V> n = new Node(k, v);
            n.next = first;
            n.prev = null;
            if(first != null) {
                first.prev = n;
            }
            cache.put(k, n);

            // New node is at the head of the doubly linked list
            first = n;

            if(cache.size() == 1) {
                last = first;
            }
        }
    }

    /*public  get(T t) {
        if(map.containsKey(t)) {
            Node n = map.get(t);
            touch(n);
        }

        return n;
    }*/

    public static void main(String[] args) {
        System.err.println("Hello LRUCache");
    }
}
