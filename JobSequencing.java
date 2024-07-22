class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, Comparator.comparingInt(j -> j.profit));
        int maxDeadline = 0;
        for (Job j : arr) {
            if (j.deadline > maxDeadline) {
                maxDeadline = j.deadline;
            }
        }
        int[] task = new int[maxDeadline];

        int timeBlock = 0;
        int maxProfit = 0;
        for (int i = n - 1; i >= 0; i--) {
            int p = arr[i].deadline;
            while (p > 0 && task[p - 1] != 0) {
                p--;
            }
            if (p > 0 && task[p - 1] == 0) {
                timeBlock++;
                task[p - 1] = arr[i].id;
                maxProfit += arr[i].profit;
            }
        }
        return new int[]{timeBlock, maxProfit};
    }
}
