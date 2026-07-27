class Solution {
    public int height(Node root) {
        if (root == null) {
            return -1;  
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}