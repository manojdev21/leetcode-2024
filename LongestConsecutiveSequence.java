/**
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
**/
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> visited = new HashMap<>();
        for (int n : nums) {
            visited.put(n, false);
        }

        AtomicInteger maxCount = new AtomicInteger();
        visited.forEach((k, v) -> {
            if (!v && visited.containsKey(k - 1)) {
                visited.put(k, true);
            } else {
                int count = 1;
                while (visited.containsKey(k + count)) {
                    count++;
                }
                if (count > maxCount.get()) {
                    maxCount.set(count);
                }
            }
        });

        return maxCount.get();
    }
}
