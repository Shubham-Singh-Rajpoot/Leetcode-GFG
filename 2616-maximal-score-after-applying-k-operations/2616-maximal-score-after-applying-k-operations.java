class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans=0;
        PriorityQueue<Integer> pq=new  PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)
            pq.add(i);
        int temp;
        for(int i=0;i<k;i++)
        {
            temp=pq.poll();
            ans+=temp;
            pq.add((int)Math.ceil(temp/3.0));
        }
        return ans;
    }
}