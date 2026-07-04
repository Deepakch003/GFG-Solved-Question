import java.util.*;

class Solution {

    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & (-idx);
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }
    }

    public int countSubstring(String s) {

        int n = s.length();

        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '1')
                prefix[i] = prefix[i - 1] + 1;
            else
                prefix[i] = prefix[i - 1] - 1;
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(sorted[0]);
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] != sorted[i - 1])
                list.add(sorted[i]);
        }

        Fenwick ft = new Fenwick(list.size());

        long ans = 0;

        for (int x : prefix) {

            int idx = Collections.binarySearch(list, x) + 1;

            ans += ft.query(idx - 1);

            ft.update(idx, 1);
        }

        return (int) ans;
    }
}