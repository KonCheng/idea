package com.koncheng;

import com.koncheng.sort.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        testSort();
    }

    private static void testSort() {
        Random random = new Random();
        int[] nums = new int[20];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        Sort sort = new QuickSort(nums);
        sort.sort();
        sort.print();
    }
}
