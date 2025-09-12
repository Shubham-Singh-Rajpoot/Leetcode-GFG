class Solution
{
    public int[] twoSum(int[] nums, int target)
    {
        int i,j;//ye do variables h index k liye
        int ans[]=new int[2];//ye answer store krne k liye 2 size ki array h
        for(i=0;i<nums.length;i++)//ye first index k liye loop
        {
            for(j=0;j<nums.length;j++)// ye 2nd index k liye loop h 
            {
                if(nums[i]+nums[j]==target && i!=j)//checking if the sum of values at index i and j equals to target
                {
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }
}