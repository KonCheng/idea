package com.koncheng.sort;

/**
 * 归并排序算法精简
 */
public class SimpleMergeSort extends AbstractSort {

    public SimpleMergeSort(int[] nums) {
        super(nums);
    }

    @Override
    public void sort() {

    }

    private void sort(int[] nums, int start, int end) {
        if (end - start > 1) {
            sort(nums, start, (start + end + 1) / 2);
            sort(nums, ((start + end + 1) / 2) + 1, end);
        } else if (end - start == 1) {
            if (nums[start] > nums[end]) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
            }
        }
//        for (int i = start; i <= end; i++) {
//        }
    }
}
