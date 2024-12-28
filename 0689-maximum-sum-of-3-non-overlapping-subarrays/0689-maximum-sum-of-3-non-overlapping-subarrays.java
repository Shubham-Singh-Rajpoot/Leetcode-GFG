class Solution
{
    ArrayList<Integer>result=new ArrayList();
    ArrayList<Integer>list=new ArrayList();
    Integer dp[][];
    public void solve(int count,int i,int n,int k)
    {
        if(count==0)
            return;
        if(i>=n)
            return;
        int take=list.get(i)+helper(count-1,i+k,n,k);
        int no_take=helper(count,i+1,n,k);
        if(take>=no_take)
        {
            result.add(i);
            solve(count-1,i+k,n,k);
        }
        else
            solve(count,i+1,n,k);
    }
    public int helper(int count,int i,int n,int k)
    {
        if(count==0)
            return 0;
        if(i>=n)
            return Integer.MIN_VALUE;
        if(dp[count][i]!=null)
            return dp[count][i];
        return dp[count][i]=Math.max(list.get(i)+helper(count-1,i+k,n,k),helper(count,i+1,n,k));
    }
    public int[] maxSumOfThreeSubarrays(int[] nums, int k)
    {
        int n=nums.length;
        int i,j;
        i=j=0;
        int sum=0;
        while(j<n)
        {
            sum+=nums[j];
            if(j-i+1==k)
            {
                list.add(sum);
                sum-=nums[i];
                i++;
            }
            j++;
        }   
        dp=new Integer[4][list.size()];
        solve(3,0,list.size(),k);
        int ans[]=new int[3];
        for(int l=0;l<3;l++)
            ans[l]=result.get(l);
        return ans;
    }
}