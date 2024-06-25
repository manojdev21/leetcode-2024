/**
53. Maximum Subarray

Given an integer array nums, find the 
subarray with the largest sum, and return its sum.
**/

class Solution {
    int maxSum = Integer.MIN_VALUE;
    int sum = 0;
    public int maxSubArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
