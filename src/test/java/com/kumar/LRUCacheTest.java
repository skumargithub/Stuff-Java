package com.kumar;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LRUCacheTest {
    @Test
    public void toStringTest() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);
        cache.insert(0, 0);
        cache.insert(1, 1);
        cache.insert(2, 2);

        String str = cache.toString();
//        System.err.println(str);

        StringBuilder sb = new StringBuilder();
        sb.append("first: (2, 2)\n");
        sb.append("last: (0, 0)\n");
        sb.append("(2, 2) -> (1, 1) -> (0, 0) -> null");

        assertTrue(sb.toString().equals(str));
    }

    @Test
    public void headAndLastTest() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);
        assertTrue(null == cache.first());
        assertTrue(null == cache.last());

        cache.insert(0, 0);
        assertTrue(cache.first().k.equals(0));
        assertTrue(cache.last().k.equals(0));

        cache.insert(1, 1);
        assertTrue(cache.first().k.equals(1));
        assertTrue(cache.last().k.equals(0));

        cache.insert(2, 2);
        assertTrue(cache.first().k.equals(2));
        assertTrue(cache.last().k.equals(0));
    }

    @Test
    public void touchTest() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);
        cache.insert(0, 0);
        cache.insert(1, 1);
        cache.insert(2, 2);
        System.err.println(cache.toString());

        cache.touch(1);
        System.err.println(cache.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("first: (1, 1)\n");
        sb.append("last: (0, 0)\n");
        sb.append("(1, 1) -> (2, 2) -> (0, 0) -> null");
        assertTrue(sb.toString().equals(cache.toString()));

        cache.touch(2);
        System.err.println(cache.toString());
        sb.setLength(0);
        sb.append("first: (2, 2)\n");
        sb.append("last: (0, 0)\n");
        sb.append("(2, 2) -> (1, 1) -> (0, 0) -> null");
        assertTrue(sb.toString().equals(cache.toString()));
    }
}
