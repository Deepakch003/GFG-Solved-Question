class Solution {
    int maxPeopleDefeated(int p) {
        int count =0;
        int max = Integer.MAX_VALUE;
        
        int i=1;
        while(i<max && p>=i*i){
            p-=i*i;
            count++;
            i++;
        }
        
        
        return count;
        
    }
};