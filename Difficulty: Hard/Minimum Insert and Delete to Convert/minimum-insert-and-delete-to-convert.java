import java.util.*;

class Solution {
    public int minInsAndDel(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            map.put(b[i], i);
        }

        
        ArrayList<Integer> arr = new ArrayList<>();

        for (int num : a) {
            if (map.containsKey(num)) {
                arr.add(map.get(num));
            }
        }

       
        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : arr) {
            int idx = Collections.binarySearch(lis, x);

            if (idx < 0) {
                idx = -(idx + 1);
            }

            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }

        int lcs = lis.size();

        return (n - lcs) + (m - lcs);
    }
}