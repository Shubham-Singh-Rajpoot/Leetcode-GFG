class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries)
    {
        int prefix[]=new int[nums.length];
        prefix[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            if((nums[i-1]%2==0 && nums[i]%2==0) || (nums[i-1]%2==1 && nums[i]%2==1))
                prefix[i]=prefix[i-1];
            else
                prefix[i]=prefix[i-1]+1;
        }
        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++)
            ans[i]=(queries[i][1]-queries[i][0]) <= prefix[queries[i][1]]-prefix[queries[i][0]];
        return ans;
    }
}