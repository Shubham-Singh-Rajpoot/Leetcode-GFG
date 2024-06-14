class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int temp=0;
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            temp=Math.max(temp,nums[i]);
            ans=ans+(temp-nums[i]);
            temp++;
        }
        return ans;
    }
}