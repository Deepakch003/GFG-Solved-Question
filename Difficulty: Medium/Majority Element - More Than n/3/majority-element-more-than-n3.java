import java.util.*;

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();


        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int limit = arr.length / 3;
        ArrayList<Integer> ans = new ArrayList<>();

        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                ans.add(entry.getKey());
            }
        }

    
        Collections.sort(ans);

        return ans;
    }
}