package com.koncheng.sort;

/**
 * 选择性排序
 * 时间复杂度O(n^2)
 *
 * @author ChenYong
 * @version 2019-7-2
 */
public class SelectiveSort extends AbstractSort {
    public SelectiveSort(int[] nums) {
        super(nums);
    }

    @Override
    public void sort() {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int minValue = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                nums[minIndex] = nums[i];
                nums[i] = minValue;
            }
        }
    }
}
