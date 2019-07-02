package com.koncheng.sort;

/**
 * 选择性排序
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
            int maxValue = nums[i];
            int maxIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] > maxValue) {
                    maxValue = nums[j];
                    maxIndex = j;
                }
            }

        }
    }
}
