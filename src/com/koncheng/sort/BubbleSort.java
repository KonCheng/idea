package com.koncheng.sort;

/**
 * 冒泡排序
 * 时间复杂度O(n^2)
 *
 * @author ChenYong
 * @version 2019-7-2
 */
public class BubbleSort extends AbstractSort {
    public BubbleSort(int[] nums) {
        super(nums);
    }

    @Override
    public void sort() {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
