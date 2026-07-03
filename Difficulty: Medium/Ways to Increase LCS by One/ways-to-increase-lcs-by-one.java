class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        // Prefix LCS
        int[][] pre = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    pre[i][j] = pre[i - 1][j - 1] + 1;
                else
                    pre[i][j] = Math.max(pre[i - 1][j], pre[i][j - 1]);
            }
        }

        // Suffix LCS
        int[][] suf = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    suf[i][j] = suf[i + 1][j + 1] + 1;
                else
                    suf[i][j] = Math.max(suf[i + 1][j], suf[i][j + 1]);
            }
        }

        int lcs = pre[n][m];
        int ans = 0;

        
        for (int pos = 0; pos <= n; pos++) {

            boolean[] used = new boolean[26];

            for (int j = 0; j < m; j++) {

                int left = pre[pos][j];
                int right = suf[pos][j + 1];

                if (left + right == lcs) {

                    int idx = s2.charAt(j) - 'a';

                    if (!used[idx]) {
                        used[idx] = true;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}