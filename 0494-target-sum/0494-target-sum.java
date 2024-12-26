class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return traverse(nums,target,0,0);
    }
    public int traverse(int nums[],int target,int i,int sum)
    {
        if(i==nums.length)
        {
            if(sum==target)
                return 1;
            return 0;
        }
        int ans=0;
        ans+=traverse(nums,target,i+1,sum+nums[i]);
        ans+=traverse(nums,target,i+1,sum-nums[i]);
        return ans;
    }
}