package com.koncheng.sort;

/**
 * 快速排序
 */
public class QuickSort extends AbstractSort {

    public QuickSort(int[] nums) {
        super(nums);
    }

    @Override
    public void sort() {
        if (nums.length <= 1) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        int pivot = nums[left];
        int leftIndex = left;
        int rightIndex = right;

        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && nums[rightIndex] > pivot) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && nums[leftIndex] < pivot) {
                leftIndex++;
            }
            if (nums[leftIndex] == nums[rightIndex] && leftIndex < rightIndex) {
                leftIndex++;
            } else {
                int tmp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = tmp;
            }
        }
        if (leftIndex - 1 > left) {
            sort(nums, left, leftIndex - 1);
        }
        if (rightIndex + 1 < right) {
            sort(nums, rightIndex + 1, right);
        }
    }

}
