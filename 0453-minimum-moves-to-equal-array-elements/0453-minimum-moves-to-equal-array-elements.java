class Solution {
    public int minMoves(int[] nums)
    {
        int min=Integer.MAX_VALUE;
        for(int i:nums)
            if(i<min)
                min=i;
        long ans=0;
        for(int i:nums)
            ans+=(i-min);
        return (int)ans;
    }
}