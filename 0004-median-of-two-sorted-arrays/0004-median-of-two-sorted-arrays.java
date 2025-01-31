class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int nums[]=new  int[nums1.length + nums2.length];
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                nums[i+j]=nums1[i];
                i++;
            }
            else
            {
                nums[i+j]=nums2[j];
                j++;
            }
        }
        while(i<nums1.length)
            nums[i+j]=nums1[i++];
        while(j<nums2.length)
            nums[i+j]=nums2[j++];
        if(nums.length%2==1)
            return (double)(nums[(i+j)/2]);
        return (nums[(i+j)/2 -1] + nums[(i+j)/2])/2.0;
    }
}