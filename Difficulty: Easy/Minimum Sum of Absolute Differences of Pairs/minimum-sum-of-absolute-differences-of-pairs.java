import java.util.*;

class Solution {
    public int findMinSum(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int minDiff = 0;

        for (int i = 0; i < a.length; i++) {
            minDiff += Math.abs(a[i] - b[i]);
        }

        return minDiff;
    }
}