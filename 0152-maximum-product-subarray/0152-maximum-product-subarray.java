class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int temp=nums[0];
        int dp[][]=new  int[nums.length][2];
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]==0)
            {
                dp[i][0]=nums[i];
                dp[i][1]=nums[i];
            }
            else
            {
                if(nums[i]<0)
                {
                    dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][1]);
                    dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][0]);
                }
                else
                {
                    dp[i][0]=Math.min(nums[i],nums[i]*dp[i-1][0]);
                    dp[i][1]=Math.max(nums[i],nums[i]*dp[i-1][1]);
                }
            }
            ans=Math.max(ans,dp[i][1]);
        }
        return ans;
    }
}