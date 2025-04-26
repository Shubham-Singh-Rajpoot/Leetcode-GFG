class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        int start=-1,end=-1,temp=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<minK || nums[i]>maxK)
                temp=i;
            if(nums[i]==minK)
                start=i;
            if (nums[i]==maxK)
                end=i;
            count=count+Math.max(0,Math.min(start,end)-temp);
        }
        return count;
    }
}