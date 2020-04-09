package com.koncheng;

import com.koncheng.leetcode.Solution;
import com.koncheng.sort.*;

import java.util.Random;

public class Main {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        int stairs = 100;
        System.out.println(solution.climbStairs(stairs));
    }

    private static void testSort() {
        Random random = new Random();
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        Sort sort = new QuickSort(nums);
        sort.sort();
        sort.print();
    }
}
