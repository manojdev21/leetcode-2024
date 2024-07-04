/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
**/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int v1 = 0;
        int c1 = 0;
        int v2 = 0;
        int c2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (c1 == 0 && nums[i] != v2) {
                v1 = nums[i];
                c1 = 1;
            } else if (c2 == 0 && nums[i] != v1) {
                v2 = nums[i];
                c2 = 1;
            } else if (v1 == nums[i]) {
                c1++;
            } else if (v2 == nums[i]) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            if (n == v1) {
                count1++;
            } else if (n == v2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        int offset = nums.length / 3;
        if (count1 > offset) {
            res.add(v1);
        }
        if (count2 > offset) {
            res.add(v2);
        }

        return res;
    }
}
