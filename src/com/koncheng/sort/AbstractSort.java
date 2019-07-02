package com.koncheng.sort;

/**
 * 排序抽象类
 *
 * @author ChenYong
 * @version 2019-7-2
 */
public abstract class AbstractSort implements Sort {
    protected int[] nums;

    public AbstractSort(int[] nums) {
        this.nums = nums;
    }

    public void print() {
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
    }
}
