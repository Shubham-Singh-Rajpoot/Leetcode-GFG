class Solution {
    public boolean isTrionic(int[] nums) {
        int i=1,p,q;
        p=i;
        while(i<nums.length && nums[i-1]<nums[i])
            i++;
        if(i==nums.length || p==i)
            return false;
        q=i;
        while(i<nums.length && nums[i-1]>nums[i])
            i++;
        if(i==nums.length || q==i)
            return false;
        p=i;
        while(i<nums.length && nums[i-1]<nums[i])
            i++;
        if(i==nums.length && p!=i)
            return true;
        return false;
    }
}