class Solution {
    static int lis(int arr[]) {
        int n = arr.length;
        if (n == 0) return 0;

        int[] dp = new int[n];
        int ans = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}