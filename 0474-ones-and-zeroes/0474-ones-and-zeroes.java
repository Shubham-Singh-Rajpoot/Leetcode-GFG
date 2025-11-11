class Solution
{
    int dp[][][];
    public int findMaxForm(String[] strs,int m,int n)
    {
        this.dp=new  int[strs.length][m+1][n+1];
        return traverse(strs,0,m,n);
    }
    public int traverse(String[] strs,int i,int m,int n)
    {
        if(i==strs.length)
            return 0;
        if(dp[i][m][n]!=0)
            return dp[i][m][n];
        int wo=traverse(strs,i+1,m,n);
        int one=0,zero=0;
        for(int j=0;j<strs[i].length();j++)
        {
            if(strs[i].charAt(j)=='1')
                one++;
            else
                zero++;
        }
        if(m>=zero && n>=one)
            wo=Math.max(wo,1+traverse(strs,i+1,m-zero,n-one));
        dp[i][m][n]=wo;
        return dp[i][m][n];
    }
}