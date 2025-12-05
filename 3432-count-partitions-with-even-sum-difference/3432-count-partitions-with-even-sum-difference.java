class Solution {
    public int countPartitions(int[] nums) {
        int total=0;
        for(int i:nums)
            total+=i;
        int ls=0;
        int ans=0;
        for(int i=0;i<nums.length-1;i++)
        {
            ls+=nums[i];
            if(Math.abs(ls-(total-ls))%2==0)
                ans++;
        }
        return ans;
    }
}