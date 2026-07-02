import java.util.*;

class Solution {

    static class Job {
        int deadline, profit;

        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }

    int[] parent;

    int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {

        int n = deadline.length;

        Job[] jobs = new Job[n];

        int maxDeadline = 0;

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        parent = new int[maxDeadline + 1];

        for (int i = 0; i <= maxDeadline; i++)
            parent[i] = i;

        int count = 0;
        int totalProfit = 0;

        for (Job job : jobs) {

            int availableSlot = find(job.deadline);

            if (availableSlot > 0) {
                count++;
                totalProfit += job.profit;

        
                parent[availableSlot] = find(availableSlot - 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);

        return ans;
    }
}