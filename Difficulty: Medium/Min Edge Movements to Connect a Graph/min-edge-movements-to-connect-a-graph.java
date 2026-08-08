class Solution {
    
    int minEdgesReq(int n, int[][] edges) {
        
        // A connected graph with n vertices needs at least n-1 edges
        if (edges.length < n - 1) {
            return -1;
        }

        DSU dsu = new DSU(n);

        // Connect vertices using existing edges
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        // Count connected components
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                components++;
            }
        }

        // Need components - 1 operations
        return components - 1;
    }
    
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return;
            }

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
}