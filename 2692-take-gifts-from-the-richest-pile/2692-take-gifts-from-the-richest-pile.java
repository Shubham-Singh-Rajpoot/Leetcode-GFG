class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq=new  PriorityQueue<>(Collections.reverseOrder());
        for(int i:gifts)
            pq.add(i);
        while(k--!=0)
        {
            if(pq.peek()==0)
                return (long)0;
            pq.add((int)Math.floor(Math.sqrt(pq.poll())));
        }
        long ans=0;
        while(!pq.isEmpty())
            ans+=pq.poll();
        return ans;
    }
}