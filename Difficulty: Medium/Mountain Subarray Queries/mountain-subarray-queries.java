class Solution {
    public ArrayList<Boolean> processQueries(int[] arr, int[][] qu) {
         int  n = arr.length;
         
         int inc[] = new int[n];
         
         inc[n-1]=n-1;
         
         for(int i=n-2;i>=0;i--){
             if(arr[i]<=arr[i+1]){
                 inc[i]=inc[i+1];
             }else {
                 inc[i]=i;
             }
             
         }
         
         
         int dec[] = new int[n];
         dec[0]=0;
         
         for(int i=1;i<n;i++){
             if(arr[i-1]>=arr[i]){
             dec[i]=dec[i-1];
             }else {
                 dec[i]=i;
             }
         }
         
         
         ArrayList<Boolean> ans = new ArrayList<>();
         for(int[] q : qu){
             int l = q[0];
             int r = q[1];
             if(dec[r]<=inc[l]){
                 ans.add(true);
             }else {
                 ans.add(false);
             }
             
             
             
         }
         
         return ans;
        
    }
}