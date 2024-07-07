/**
Largest subarray with 0 sum

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
**/
class GfG
{
    int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int longest = 0;
        map.put(0, -1); // base case
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
                continue;
            }
            int length = i - map.get(sum);
            if (length > longest) {
                longest = length;
            }
        }

        return longest;
    }
}
