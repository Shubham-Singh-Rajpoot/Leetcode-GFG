class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<nums.length;i++)
        {
            int min=lower-nums[i];
            int max=upper-nums[i];
            int startindex=nums.length,endindex=-1;
            int low=i+1,high=nums.length-1,mid=0;
            // System.out.println(nums[i]+"\t"+min+"\t"+max);
            while(low<=high)//nearest greater or equal to min
            {
                mid=low+(high-low)/2;
                // System.out.println(low+" "+mid+" "+high);
                if(nums[mid]>=min)
                {
                    if(mid<startindex)
                        startindex=mid;
                    high=mid-1;
                }
                if(nums[mid]<min)
                    low=mid+1;
            }
            // System.out.println("Found startindex: "+startindex);
            low=i+1;
            high=nums.length-1;
            while(low<=high)
            {
                mid=low+(int)Math.ceil((high-low)/2.0);
                //System.out.println(low+" "+mid+" "+high);
                if(nums[mid]<=max)
                {
                    low=mid+1;
                    endindex=mid;
                }
                if(nums[mid]>max)
                    high=mid-1;
            }
            // System.out.println("Found endindex: "+endindex);
            // System.out.println("Prev ans: "+ans);
            ans+=Math.max(0,endindex-startindex+1);
            // System.out.println("Now ans: "+ans);

        }
        return ans;
        // int umin=nums[0];
        // int umax=nums[nums.length-1];
        // int minimum,maximum;
        // for(int i=lower;i<=upper;i++)
        // {
        //     min=umin;
        //     max=umax;
        //     if((long)min+(long)max < (long)i)
        //         min= i-max;
        //     else
        //         max= i-min;
        //     if(min<umin || max>umax)
        //         continue;
        //     //binary search for index of number=min or index of number just greater than min
        //     int low=0,high=nums.length-1,mid;
        //     while(low<=high)
        //     {
        //         mid=low+(high-low)/2;
        //         if(nums[mid]<=min)
        //             high=mid-1;
        //         if(nums[mid]>=min)
        //     }      
        // }
        // return 0;
    }
}