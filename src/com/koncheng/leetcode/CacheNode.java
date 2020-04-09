package com.koncheng.leetcode;

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
