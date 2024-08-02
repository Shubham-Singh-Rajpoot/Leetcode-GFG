class Solution {
    public int minSwaps(int[] nums)
    {
        int n=nums.length;
        int totalOnes=0;
        for (int num:nums)
            totalOnes+=num;
        if (totalOnes==0 || totalOnes==n)
            return 0;
        int minSwaps=Integer.MAX_VALUE;
        int zerosInWindow=0;
        for (int i=0;i<totalOnes;i++)
            if(nums[i]==0)
                zerosInWindow++;
        minSwaps=zerosInWindow;
        for(int i=totalOnes;i<n+totalOnes;i++)
        {
            if(nums[i%n]==0)
                zerosInWindow++;
            if(nums[(i-totalOnes)%n]==0)
                zerosInWindow--;
            minSwaps=Math.min(minSwaps,zerosInWindow);
        }
        return minSwaps;
    }
}