/**
18. 4Sum

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
a, b, c, and d are distinct.
**/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3;) {
            for (int j = i + 1; j < n - 2;) {
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        int temp = nums[k];
                        do {
                            k++;
                        } while (nums[k] == temp && k < l);
                    } else if (sum < target) {
                        int temp = nums[k];
                        do {
                            k++;
                        } while (nums[k] == temp && k < l);
                    } else {
                        int temp = nums[l];
                        do {
                            l--;
                        } while (nums[l] == temp && l > k);
                    }
                }

                int temp = nums[j];
                do {
                    j++;
                } while (nums[j] == temp && j < n - 2);
            }
            int temp = nums[i];
            do {
                i++;
            } while (nums[i] == temp && i < n - 3);
        }
        return res;
    }
}
