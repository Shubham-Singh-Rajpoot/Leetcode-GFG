class Solution
{
    public int waysToSplitArray(int[] nums)
    {
        int count=0;
        long sum=0;
        for(int i:nums)
            sum+=i;
        long val=0;
        for(int i=0;i<nums.length-1;i++)
        {
            val+=nums[i];
            sum-=nums[i];
            if(val>=sum)
                count++;
        }
        return count;
    }
}