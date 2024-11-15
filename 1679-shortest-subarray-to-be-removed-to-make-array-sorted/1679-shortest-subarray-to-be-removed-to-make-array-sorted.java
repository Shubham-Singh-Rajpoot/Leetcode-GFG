class Solution {
    public int findLengthOfShortestSubarray(int[] arr)
    {
        int i=0,j=arr.length-1;
        for(i=0;i<arr.length-1 && arr[i]<=arr[i+1];i++)
        {}
        if(i==arr.length-1)
            return 0;
        for(j=arr.length-1;j>i && arr[j-1]<=arr[j];j--)
        {}
        int ans=Math.min(j,arr.length-i-1);
        for(int k=0,l=j;k<=i && l<arr.length; )
        {
            if(arr[k]<=arr[l])
                ans=Math.min(ans,l-k++-1);
            else
                l++;
        }
        return ans;
    }
}