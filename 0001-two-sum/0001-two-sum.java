class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        int i,j;
        int ans[]=new int[2];
        for(i=0;i<nums.length;i++)
        {
            for(j=0;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target && i!=j)
                {
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
            if(j!=nums.length)
                break;
        }
        return ans;
    }
}