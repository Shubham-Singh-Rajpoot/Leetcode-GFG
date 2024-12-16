class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k-->0)
        {
            int ind=0;
            for(int i=1;i<nums.length;i++)
                if(nums[i]<nums[ind])
                    ind=i;
            nums[ind]*=multiplier;
        }
        return nums;
    }
}