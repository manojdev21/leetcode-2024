/**
493. Reverse Pairs

Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
**/
class Solution {
    public int reversePairs(int[] nums) {
        return reversePairs(nums, 0, nums.length - 1);
    }

    public int reversePairs(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int totalCount = 0;
        totalCount += reversePairs(nums, start, mid);
        totalCount += reversePairs(nums, mid + 1, end);
        totalCount += mergeAndCountPairs(nums, start, end, mid);
        return totalCount;
    }

    public int mergeAndCountPairs(int[] nums, int start, int end, int mid) {
        int j = mid + 1;
        int totalCount = 0;
        int count = 0;
        for (int i = start; i <= mid; i++) {
            while (j <= end) {
                long val = (long) nums[j];
                if (nums[i] > (2 * val)) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
            totalCount += count;
        }

        int[] temp = new int[end - start + 1];
        int p = start;
        int q = mid + 1;
        int k = 0;
        while (p <= mid && q <= end) {
            if (nums[p] > nums[q]) {
                temp[k++] = nums[q++];
            } else {
                temp[k++] = nums[p++];
            }
        }
        while (p <= mid) {
            temp[k++] = nums[p++];
        }
        while (q <= end) {
            temp[k++] = nums[q++];
        }
        for (int i = 0; i < k; i++) {
            nums[start + i] = temp[i];
        }

        return totalCount;
    }
}
