class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=1;
        int f=0;
        int s=0;
        while(f<nums.length && s<nums.length)
        {
            if((nums[f]-nums[s])<=2*k)
                f++;
            else
            {
                ans=Math.max(ans,f-s);
                s++;
            }
        }
        ans=Math.max(ans,f-s);
        return ans;
    }
}