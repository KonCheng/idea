package com.koncheng.leetcode;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private CacheNode head;
    private CacheNode tail;
    private HashMap<Integer, CacheNode> valueMap;
    private int length = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.valueMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (this.valueMap.containsKey(key)) {
            CacheNode node = this.valueMap.get(key);
            resetHeadNode(node);
            return this.valueMap.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (this.head == null) {
            this.head = new CacheNode(key, value);
            this.length++;
            this.valueMap.put(key, this.head);
            this.tail = this.head;
            return;
        }
        if (valueMap.containsKey(key)) {
            CacheNode node = this.valueMap.get(key);
            node.value = value;
            resetHeadNode(node);
        } else {
            if (this.length == this.capacity) {
                this.valueMap.remove(this.tail.key);
                if (this.tail.prev != null) {
                    this.tail.prev.next = null;
                }
                this.tail = this.tail.prev;
                this.length--;
            }
            CacheNode node = new CacheNode(key, value);
            node.next = this.head;
            this.head.prev = node;
            this.head = node;

            this.valueMap.put(key, node);
            this.length++;
        }
    }

    private void resetHeadNode(CacheNode node) {
        if (node.prev != null) {
            if (this.tail == node) {
                this.tail = node.prev;
            }
            CacheNode prev = node.prev;
            prev.next = node.next;
            if (node.next != null) {
                node.next.prev = node.prev;
            }
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public class CacheNode {
        public int key;
        public int value;
        public CacheNode next;
        public CacheNode prev;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void print() {
            CacheNode cur = this;
            while (cur != null) {
                System.out.println(cur.key + ": " + cur.value);
                cur = cur.next;
            }
        }
    }

}