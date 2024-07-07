/**
Given an array of integers A and an integer B.

Find the total number of subarrays having bitwise XOR of all elements equals to B.
**/
public class Solution {
    public int countSubArrayXOR(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int xor = 0;
        int totalCount = 0;
        for (int n : nums) {
            xor ^= n;
            if (map.containsKey(xor ^ k)) {
                totalCount += map.get(xor ^ k);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return totalCount;
    }
}
