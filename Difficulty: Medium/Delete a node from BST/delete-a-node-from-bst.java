/* Structure of a Binary Search Tree node
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
    public Node delNode(Node root, int x) {
        if (root == null) return null;

        if (x < root.data) {
            root.left = delNode(root.left, x);
        } else if (x > root.data) {
            root.right = delNode(root.right, x);
        } else {
            
            if (root.left == null) return root.right;

            
            if (root.right == null) return root.left;

            
            Node successor = findMin(root.right);
            root.data = successor.data;
            root.right = delNode(root.right, successor.data);
        }

        return root;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}