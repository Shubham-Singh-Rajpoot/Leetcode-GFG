class Solution {
    public int maximumSum(int[] nums) {
        int sum[]=new  int[nums.length];
        int rsum[]=new  int[nums.length];
        int max=nums[0];
        int i;
        sum[0]=nums[0];
        rsum[nums.length-1]=nums[nums.length-1];
        for(i=1;i<nums.length;i++)
        {
            sum[i]=Math.max(nums[i],nums[i]+sum[i-1]);
            rsum[nums.length-i-1]=Math.max(nums[nums.length-i-1],nums[nums.length-i-1]+rsum[nums.length-i]);
        }
        if(nums.length>1)
        {
        max=Math.max(max,nums[0]);
        max=Math.max(max,rsum[1]);
        max=Math.max(max,nums[nums.length-1]);
        max=Math.max(max,sum[nums.length-2]);
        }
        for(i=1;i<nums.length-1;i++)
        {
            max=Math.max(max,sum[i-1]+rsum[i+1]);
            max=Math.max(max,sum[i-1]+rsum[i]);
        }
        return max;
    }
}