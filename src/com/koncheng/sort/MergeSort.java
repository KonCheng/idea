package com.koncheng.sort;


/**
 * 归并排序
 */
public class MergeSort extends AbstractSort {

    public MergeSort(int[] nums) {
        super(nums);
    }

    @Override
    public void sort() {
        NumList root = new NumList(nums);
        spilt(root);
        sort(root);
    }

    void spilt(NumList numList) {
        if (numList == null) {
            return;
        }
        int length = numList.numList.length;
        if (length > 1) {
            int[] left = new int[(length + 1) / 2];
            int[] right = new int[length - ((length + 1) / 2)];
            for (int i = 0; i < length; i++) {
                if (i < ((length + 1) / 2)) {
                    left[i] = numList.numList[i];
                } else {
                    right[i - left.length] = numList.numList[i];
                }
            }
            numList.left = new NumList(left);
            numList.right = new NumList(right);
            spilt(numList.left);
            spilt(numList.right);
        }
    }

    void sort(NumList numList) {
        if (numList == null) {
            return;
        }
        int length = numList.numList.length;
        if (length > 2) {
            sort(numList.left);
            sort(numList.right);

            int leftIndex = 0;
            int rightIndex = 0;
            for (int i = 0; i < length; i++) {
                if (leftIndex >= numList.left.numList.length) {
                    numList.numList[i] = numList.right.numList[rightIndex];
                    rightIndex++;
                    continue;
                }
                if (rightIndex >= numList.right.numList.length) {
                    numList.numList[i] = numList.left.numList[leftIndex];
                    leftIndex++;
                    continue;
                }
                if (numList.left.numList[leftIndex] > numList.right.numList[rightIndex]) {
                    numList.numList[i] = numList.right.numList[rightIndex];
                    rightIndex++;
                } else {
                    numList.numList[i] = numList.left.numList[leftIndex];
                    leftIndex++;
                }
            }

        } else if (length == 2) {
            if (numList.left.numList[0] > numList.right.numList[0]) {
                numList.numList[0] = numList.right.numList[0];
                numList.numList[1] = numList.left.numList[0];
            } else {
                numList.numList[0] = numList.left.numList[0];
                numList.numList[1] = numList.right.numList[0];
            }
        }
    }

    class NumList {
        int[] numList;
        NumList left;
        NumList right;

        public NumList(int[] numList) {
            this.numList = numList;
        }
    }
}
