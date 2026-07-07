import java.util.*;
class Solution {
    public int largestArea(int n, int m, int[][] arr) {
       
        
        
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        
        for(int [] cell : arr){
            row.add(cell[0]);
            col.add(cell[1]);
        }
        
        row.add(0);
        row.add(n+1);
        col.add(0);
        col.add(m+1);
        
        Collections.sort(row);
        Collections.sort(col);
        
        int rowGap=0;
        int colGap=0;
        
        
        for(int i=1;i<row.size();i++){
            rowGap=Math.max(rowGap,row.get(i)-row.get(i-1)-1);
        }
        
        for(int i=1;i<col.size();i++){
            colGap=Math.max(colGap,col.get(i)-col.get(i-1)-1);
        }
        
        
        return rowGap*colGap;
        
        
        
        
    }
}