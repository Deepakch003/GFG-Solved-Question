import java.util.*;

class Solution {
    public int activitySelection(int[] start, int[] finish) {

        int n = start.length;

        
        int[][] activity = new int[n][2];

        for (int i = 0; i < n; i++) {
            activity[i][0] = start[i];
            activity[i][1] = finish[i];
        }

    
        Arrays.sort(activity, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int count = 1;
        int lastEnd = activity[0][1];

        for (int i = 1; i < n; i++) {

            
            if (activity[i][0] > lastEnd) {
                count++;
                lastEnd = activity[i][1];
            }
        }

        return count;
    }
}