import java.util.*;

class Solution {
    public int countKdivPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int rem = num % k;
            int complement = (k - rem) % k;

            count += map.getOrDefault(complement, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}