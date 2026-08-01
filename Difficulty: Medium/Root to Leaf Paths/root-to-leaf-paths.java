/* Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        dfs(root, path, ans);
        return ans;
    }

    private void dfs(Node root, ArrayList<Integer> path,
                     ArrayList<ArrayList<Integer>> ans) {
        if (root == null) return;

        path.add(root.data);
        
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(root.left, path, ans);
            dfs(root.right, path, ans);
        }

        
        path.remove(path.size() - 1);
    }
}