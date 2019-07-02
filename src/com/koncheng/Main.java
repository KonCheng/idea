package com.koncheng;

import com.koncheng.sort.BubbleSort;
import com.koncheng.sort.Sort;

public class Main {

    public static void main(String[] args) {
        // write your code here
        testSort();
    }

    private static void testSort() {
        int[] nums = {7, 3, 5, 9, 6, 4, 2, 8, 1};
        Sort sort = new BubbleSort(nums);
        sort.sort();
        sort.print();
    }
}
