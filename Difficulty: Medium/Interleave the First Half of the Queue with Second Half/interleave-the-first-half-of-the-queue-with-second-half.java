class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        Queue<Integer> firstHalf = new ArrayDeque<>();

    int size = q.size();

    for(int i=0;i<size/2;i++){
      firstHalf.add(q.remove());
    }

    while(!firstHalf.isEmpty()){
      q.add(firstHalf.remove());
      q.add(q.remove());
    }
        
    }
}
