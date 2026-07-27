class Solution {

    public void toSumTree(Node root) {
        transform(root);
    }

    private int transform(Node node) {
        if (node == null) {
            return 0;
        }

        int oldValue = node.data;

        int leftSum = transform(node.left);
        int rightSum = transform(node.right);

        
        node.data = leftSum + rightSum;

        
        return oldValue + node.data;
    }
}