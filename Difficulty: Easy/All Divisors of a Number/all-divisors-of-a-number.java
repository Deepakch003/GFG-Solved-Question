import java.util.*;
class Solution {
    public ArrayList<Integer> getDivisors(int n) {
    ArrayList<Integer> list = new ArrayList<>();
    
    for(int i=1;i*i<=n;i++){
        if(n%i==0){
            list.add(i);
            
            if(i!=n/i){
                list.add(n/i);
            }
        }
    }
    
    Collections.sort(list);
    
    return list;
        
    }
}