package com.koncheng.sort;

/**
 * 插入排序
 * 时间复杂度O(n^2)
 *
 */
public class InsertSort extends AbstractSort {

    public InsertSort(int[] nums) {
        super(nums);
    }

    @Override
    public void sort() {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            int tmp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= tmp) {
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                } else {
                    break;
                }
            }
        }

    }
}
