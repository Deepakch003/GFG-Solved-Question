class Solution {

    public int maxDotProduct(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                
                if ((n - i) < (m - j)) {
                    dp[i][j] = Integer.MIN_VALUE;
                    continue;
                }

                int take = a[i] * b[j];

                if (j + 1 < m) {
                    take += dp[i + 1][j + 1];
                }

                int skip = dp[i + 1][j];

                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[0][0];
    }
}