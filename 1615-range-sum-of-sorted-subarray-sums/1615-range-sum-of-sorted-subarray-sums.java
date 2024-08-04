class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int ar[]=new  int[n*(n+1)/2];
        ar[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            ar[i]=(nums[i]+=nums[i-1]);
        int k=nums.length;
        for(int i=1;i<nums.length;i++)
            for(int j=i;j<nums.length;j++)
                ar[k++]=nums[j]-nums[i-1];
        Arrays.sort(ar);
        int ans=0;
        for( ;left<=right;left++)
            ans=(int)(((long)ans+(long)ar[left-1])%1000000007);
        return ans;
    }
}