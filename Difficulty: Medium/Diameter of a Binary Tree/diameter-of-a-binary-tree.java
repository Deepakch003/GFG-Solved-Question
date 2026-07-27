class Solution {

    private int diameter = 0;

    public int diameter(Node root) {
        height(root);
        return diameter;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        
        diameter = Math.max(diameter, leftHeight + rightHeight);

        
        return 1 + Math.max(leftHeight, rightHeight);
    }
}