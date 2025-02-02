class Solution {
    public boolean check(int[] nums)
    {
        int i;
        for(i=1;i<nums.length;i++)
            if(nums[i]<nums[i-1])
                break;
        for(int j=0;j<nums.length-1;j++)
            if(nums[(i+j+1)%nums.length]<nums[(i+j)%nums.length])
                return false;
        return true;
    }
}