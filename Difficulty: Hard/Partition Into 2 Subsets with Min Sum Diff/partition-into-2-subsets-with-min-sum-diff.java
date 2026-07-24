class Solution {
    public int minDifference(int arr[]) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int num : arr) {
            for (int j = sum; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= sum / 2; s1++) {
            if (dp[s1]) {
                ans = Math.min(ans, sum - 2 * s1);
            }
        }

        return ans;
    }
}