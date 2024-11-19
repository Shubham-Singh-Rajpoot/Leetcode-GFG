class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans=0;
        int ws=0,we=0;
        long sum=0;
        Set<Integer> set=new  HashSet<>();
        for(we=0;we<nums.length;we++)
        {
            if(set.contains(nums[we]))
            {
                while(set.contains(nums[we]))
                {
                    set.remove(nums[ws]);
                    sum-=nums[ws];
                    ws++;
                }
                set.add(nums[we]);
                sum+=nums[we];
            }
            else
            {
                set.add(nums[we]);
                sum+=nums[we];
            }
            if(set.size()==k)
            {
                ans=Math.max(ans,sum);
                set.remove(nums[ws]);
                sum-=nums[ws];
                ws++;
            }
        }
        return ans;        
    }
}