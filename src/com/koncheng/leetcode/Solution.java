package com.koncheng.leetcode;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int cur = Integer.MIN_VALUE;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }

        ListNode list1, list2;
        if (l1.val <= l2.val) {
            list1 = l1;
            list2 = l2;
        } else {
            list1 = l2;
            list2 = l1;
        }

        ListNode head = list1;
        ListNode pre = list1;
        ListNode curList;

        int val1 = list1.val, val2 = list2.val;
        while (list1 != null || list2 != null) {
            while (list1 != null && cur <= list1.val && list1.val <= val2) {
                curList = list1;
                cur = list1.val;
                System.out.println(cur);
                list1 = list1.next;
                val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
                pre.next = curList;
                pre = curList;
            }
            while (list2 != null && cur <= list2.val && list2.val <= val1) {
                curList = list2;
                cur = list2.val;
                System.out.println(cur);
                list2 = list2.next;
                val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
                pre.next = curList;
                pre = curList;
            }
        }
        return head;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int carry = 1;
        while (x / carry != 0) {
            int num = x / carry % 10;
            System.out.println("num: " + num);
            y = y * 10 + num;
            System.out.println("y: " + y);
            if (carry >= Integer.MAX_VALUE / 10) {
                break;
            }
            carry = carry * 10;
        }

        return x == y;
    }

    public boolean isPalindrome(String x) {
        int left, right;
        if (x.length() % 2 == 0) {
            left = x.length() / 2 - 1;
            right = left + 1;
        } else {
            left = x.length() / 2;
            right = left;
        }

        while (left >= 0 && right < x.length()) {
            if (x.charAt(left--) != x.charAt(right++)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0) {
                stack.push(s.charAt(i));
            } else {
                if (map.get(stack.peek()) != null && s.charAt(i) == map.get(stack.peek())) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.size() == 0;
    }

    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    public int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    public void print(int x) {
        int y = 0;
        int carry = 1;
        while (x / carry != 0) {
            int num = x / carry % 10;
            y = y * 10 + num;
            System.out.println(num);
            carry = carry * 10;
        }
        System.out.println(y);
    }

    /**
     * 寻找两个有序数组的交集
     *
     * @param array1
     * @param array2
     * @return
     */
    public int[] retainAll(int[] array1, int[] array2) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] == array2[j]) {
                list.add(array1[i]);
                i++;
                j++;
            } else {
                if (array1[i] > array2[j]) {
                    j++;
                } else {
                    i++;
                }
            }
        }
        int[] result = list.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }

    /**
     * 寻找字符数组中唯一不同的字符
     *
     * @param char1
     * @param char2
     * @return
     */
    public char find(char[] char1, char[] char2) {
        int i = 0;
        while (i < char1.length && i < char2.length) {
            if (char1[i] != char2[i]) {
                return char1[i];
            } else {
                i++;
            }
        }
        if (char1.length > char2.length) {
            return char1[i];
        } else {
            return char2[i];
        }
    }
}
