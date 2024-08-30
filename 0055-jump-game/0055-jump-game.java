class Solution {
    public boolean canJump(int[] nums)
    {
        int i,lasttrue=nums.length-1;
        for(i=nums.length-1;i>=0;i--)
            if((i+nums[i])>=lasttrue)
                lasttrue=i;
        if(lasttrue==0)
            return true;
        return false;
    }
}