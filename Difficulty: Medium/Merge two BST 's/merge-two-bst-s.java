/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left, right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {

    void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public ArrayList<Integer> merge(Node r1, Node r2) {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        inorder(r1, a);
        inorder(r2, b);

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j))
                ans.add(a.get(i++));
            else
                ans.add(b.get(j++));
        }

        while (i < a.size())
            ans.add(a.get(i++));

        while (j < b.size())
            ans.add(b.get(j++));

        return ans;
    }
}