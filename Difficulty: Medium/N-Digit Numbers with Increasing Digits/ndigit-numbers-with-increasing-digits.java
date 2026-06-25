class Solution {
    public ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
            return ans;
        }

        solve(n, 0, 1, ans);

        return ans;
    }

    private void solve(int n, int num, int start, ArrayList<Integer> ans) {

        if (String.valueOf(num).length() == n) {
            ans.add(num);
            return;
        }

        for (int digit = start; digit <= 9; digit++) {
            solve(n, num * 10 + digit, digit + 1, ans);
        }
    }
}