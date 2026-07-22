class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        int[] dp = new int[capacity + 1];

        for (int i = 0; i < n; i++) {
            for (int j = wt[i]; j <= capacity; j++) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }

        return dp[capacity];
    }
}