class Solution {
    public int lenLongestFibSubseq(int[] arr)
    {
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                int target = arr[i]+arr[j];
                int last = arr[j];
                int m = j+1,n = arr.length-1;
                int len = 2;
                while(m<=n)
                {
                    int mid= (m+n)/2;
                    if(arr[mid]>target)
                        n = mid-1;
                    else if(arr[mid]<target)
                        m = mid+1;
                    else
                    {
                       len++;
                       target = arr[mid]+last;
                       last = arr[mid];
                       n = arr.length-1;
                    }
                }
                ans = Math.max(ans, len);
            }
        }
        return ans==2?0:ans;   
    }
}