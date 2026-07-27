class Solution {
    public Node LCA(Node root, Node n1, Node n2) {
        if (root == null) {
            return null;
        }

        if (root == n1 || root == n2) {
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        return (left != null) ? left : right;
    }
}