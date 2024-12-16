class Solution {
    public long findScore(int[] nums)
    {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{int cmp=Integer.compare(nums[a],nums[b]);
        if(cmp==0)
            return Integer.compare(a,b);
        return cmp;
    }
);
        Set<Integer> set=new  HashSet<>();
        for(int i=0;i<nums.length;i++)
            pq.add(i);
        long score=0;
        while(!pq.isEmpty())
        {
            int ind=pq.poll();
            if(set.contains(ind))
                continue;
            score+=nums[ind];
            if(!set.contains(ind-1))
                set.add(ind-1);
            if(!set.contains(ind+1))
                set.add(ind+1);
        }
        return score;
    }
}