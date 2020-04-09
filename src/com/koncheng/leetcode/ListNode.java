package com.koncheng.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        if (nums.length > 0) {
            this.val = nums[0];
            ListNode preNode = this;
            for (int i = 1; i < nums.length; i++) {
                ListNode node = new ListNode(nums[i]);
                preNode.next = node;
                preNode = node;
            }
        }
    }

    public void print() {
        ListNode cur = this;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
