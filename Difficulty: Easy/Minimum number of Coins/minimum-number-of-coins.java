class Solution {
    public int findMin(int n) {
    
      int coins [] = {1,2,5,10};
      
      int count=0;
      
      for(int i=coins.length-1;i>=0;i--){
          if(coins[i]<=n){
              while(coins[i]<=n){
                  count++;
                  n-=coins[i];
              }
          }
      }
      
      
      return count;
        
    }
}
