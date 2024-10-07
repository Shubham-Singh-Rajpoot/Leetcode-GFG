class Solution {
    public int maxGoodNumber(int[] nums) {
        int ans=0;
        ans=Math.max(ans,Integer.parseInt(Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[2]),2));
        ans=Math.max(ans,Integer.parseInt(Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[1]),2));
        ans=Math.max(ans,Integer.parseInt(Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[2]),2));
        ans=Math.max(ans,Integer.parseInt(Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[0]),2));
        ans=Math.max(ans,Integer.parseInt(Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[0])+Integer.toBinaryString(nums[1]),2));
        ans=Math.max(ans,Integer.parseInt(Integer.toBinaryString(nums[2])+Integer.toBinaryString(nums[1])+Integer.toBinaryString(nums[0]),2));
        return ans;
    }
}