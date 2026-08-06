class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int d1 = a[0] * a[0] + a[1] * a[1];
            int d2 = b[0] * b[0] + b[1] * b[1];
            return d2 - d1;   
        });

        for (int[] p : points) {
            pq.offer(p);

            if (pq.size() > k)
                pq.poll();
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(p[0]);
            temp.add(p[1]);
            ans.add(temp);
        }

        return ans;
    }
}