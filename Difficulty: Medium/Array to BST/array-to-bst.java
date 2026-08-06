/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    public Node sortedArrayToBST(int[] arr) {
        return build(arr, 0, arr.length - 1);
    }

    private Node build(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;

        Node root = new Node(arr[mid]);

        root.left = build(arr, low, mid - 1);
        root.right = build(arr, mid + 1, high);

        return root;
    }
}