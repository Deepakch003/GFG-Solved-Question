// class Solution {
//     public int maxSumSubarray(int[] arr) {

//         int noDelete = arr[0];
//         int oneDelete = Integer.MIN_VALUE;
//         int ans = arr[0];

//         for (int i = 1; i < arr.length; i++) {

//             int prevNoDelete = noDelete;
//             int prevOneDelete = oneDelete;

//             noDelete = Math.max(prevNoDelete + arr[i], arr[i]);

//             oneDelete = Math.max(prevNoDelete, prevOneDelete + arr[i]);

//             ans = Math.max(ans, Math.max(noDelete, oneDelete));
//         }

//         return ans;
//     }
// }
class Solution{

public int maxSumSubarray(int[] arr)
    {
        int n = arr.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = arr[0];

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(arr[i], pre[i - 1] + arr[i]);
        }
        suff[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suff[i]
                = Math.max(arr[i], suff[i + 1] + arr[i]);
        }
        int ans = Arrays.stream(pre).max().getAsInt();
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, pre[i - 1] + suff[i + 1]);
        }

        return ans;
    }
}

