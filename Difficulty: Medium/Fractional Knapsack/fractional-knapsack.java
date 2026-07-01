class Solution {
    
    
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double ratio[][] = new double[val.length][2];
        
        for(int i=0;i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)wt[i];
        }
        
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        
        
        
        
        double finalVal=0;
        
        for(int i=ratio.length-1;i>=0;i--){
            int idx = (int)ratio[i][0];
            
            if(capacity>=wt[idx]){
                finalVal+=val[idx];
                capacity-=wt[idx];
            }else {
                finalVal+=(ratio[i][1])*capacity;
                capacity=0;
                break;
            }
        }
        
        
        
        return finalVal;
        
    }
}