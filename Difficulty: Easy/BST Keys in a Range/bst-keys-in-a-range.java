/* Structure of BST tree Node
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
    public ArrayList<Integer> nodesInRange(Node root, int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, low, high, ans);
        return ans;
    }

    private void inorder(Node root, int low, int high, ArrayList<Integer> ans) {
        if (root == null) return;

        if (root.data > low) {
            inorder(root.left, low, high, ans);
        }

        if (root.data >= low && root.data <= high) {
            ans.add(root.data);
        }

        if (root.data < high) {
            inorder(root.right, low, high, ans);
        }
    }
}