class Solution {
    public int countMinOperations(int arr[]) {
        int setBit =0;
        int bitLen =0;
        
        for(int num : arr){
            int temp = num;
            
            
            while(temp>0){
                if(temp%2==1){
                    setBit++;
                }
                temp=temp/2;
            }
            
            int temp1=num;
            int len =0;
            
            while(temp1>0){
                
                len++;
                temp1=temp1/2;
               
            }
            
            bitLen=Math.max(len,bitLen);
        }
        
        
        return setBit+(bitLen-1);
        
    }
}