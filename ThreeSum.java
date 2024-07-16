class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int p = i + 1;
            int q = nums.length - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>(3);
                    list.add(nums[i]);
                    list.add(nums[p]);
                    list.add(nums[q]);
                    p++;
                    q--;
                    while (p < q && nums[p] == nums[p - 1]) p++;
                    while (p < q && nums[q] == nums[q + 1]) q--;
                    res.add(list);
                } else if (sum < 0) {
                    p++;
                    while (p < q && nums[p] == nums[p - 1]) p++;
                } else {
                    q--;
                    while (p < q && nums[q] == nums[q + 1]) q--;
                }
            }
        }
        return res;
    }
}
