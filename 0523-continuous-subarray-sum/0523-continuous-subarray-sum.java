class Solution
{
    public boolean checkSubarraySum(int[] nums, int k)
    {
        int i,j;
        for(i=1;i<nums.length;i++)//checking a subarray of length 2 having elements 0(0 is multiple of k)
            if(nums[i] == 0 && nums[i-1] == 0)
                return true;
        for(i=1;i<nums.length;i++)
        {
            nums[i] += nums[i-1];//Prefix sum
            if(nums[i] % k ==0)//if at any time Prefix sum become divisible by k
                return true;
            j=i;
            while(j> 1 && nums[i] > k) {
                if((nums[i] - nums[j-2]) % k ==0)//if sum of any n elements becomes divisible by k
                    return true;
                j--;//checking all previous numbers
            }
        }
        return false;
    }
}