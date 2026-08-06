class Solution {
    public int minCost(int[] arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x : arr)
            pq.offer(x);

        int cost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            cost += sum;

            pq.offer(sum);
        }

        return cost;
    }
}