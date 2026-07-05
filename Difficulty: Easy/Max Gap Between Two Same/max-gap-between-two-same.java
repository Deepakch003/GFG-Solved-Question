import java.util.*;

class Solution {
    public int maxCharGap(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int maxGap = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (mp.containsKey(ch)) {
                maxGap = Math.max(maxGap, i - mp.get(ch) - 1);
            } else {
                mp.put(ch, i); 
            }
        }

        return maxGap;
    }
}