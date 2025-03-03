class Solution {
    public int[] pivotArray(int[] nums, int pivot)
    {
        int ar[]=new   int[nums.length];
        int pindex=0,nindex=nums.length-1,j=nums.length-1,i;
        for(i=0;i<nums.length;i++,j--)
        {
            if(nums[i]<pivot)
            {
                ar[pindex]=nums[i];
                pindex+=1;
            }
            if(nums[j]>pivot)
            {
                ar[nindex]=nums[j];
                nindex-=1;
            }
        }
        for(i=pindex;i<=nindex;i++)
            ar[i]=pivot;
        return ar;
    }
}