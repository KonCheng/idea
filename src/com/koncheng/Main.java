package com.koncheng;

import com.koncheng.leetcode.Solution;
import com.koncheng.sort.*;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        char[] array1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] array2 = {'a', 'b', 'c', 'd', 'f', 'g'};
        System.out.println(solution.find(array1, array2));
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
