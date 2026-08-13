class Solution {
    static int largestPrimeFactor(int n) {
        
        int largest=1;
        
        for(int i=2;i<=n/i;i++){
            if(n%i==0){
                largest=i;
            }
            
            while(n%i==0){
                n=n/i;
            }
        }
        
        if(n>1){
            largest=n;
        }
        
        return largest;
      
        
    }
}