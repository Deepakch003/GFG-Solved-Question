/* Definition for Node
class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
};
*/

class Solution {

    int ans = -1;

    public int kthAncestor(Node root, int k, int node) {
        dfs(root, k, node);
        return ans;
    }

    private int dfs(Node root, int k, int node) {
        if (root == null) {
            return -1;
        }

        if (root.data == node) {
            return 0;
        }

        int left = dfs(root.left, k, node);
        int right = dfs(root.right, k, node);

        int dist = Math.max(left, right);

        if (dist != -1) {
            dist++;

            if (dist == k) {
                ans = root.data;
            }

            return dist;
        }

        return -1;
    }
}