class Solution {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        if (n==0)
        {
            return 0;
        }
        
        int mov1 = towerOfHanoi(n-1,from,aux,to);
        int mov2=1;
        int mov3=towerOfHanoi(n-1,aux,to,from);
        
        
        return mov1+mov2+mov3;
    }
}
