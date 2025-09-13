class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget)
    {
        long ar[][]=new  long[forget+1][n+1];
        ar[0][0]=1;
        for(int day=1;day<n;day++)
        {
            for(int i=0;i<forget;i++)
            {
                ar[i+1][day]=ar[i][day-1];
            }
            long total=0;
            for(int i=delay;i<forget;i++)
            {
                total=(total+ar[i][day])%1000000007;
            }
            ar[0][day]=total;
        }
        long ans=0;
        for(int i=0;i<forget;i++)
        {
            ans=(ans+ar[i][n-1])%1000000007;
        }
        return (int)ans;
    }
}