class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n)
    {
        long sum=0;
        for(int i=0;i<rolls.length;i++)
            sum+=rolls[i];
        int totalcnt=rolls.length+n;
        long reqsum=((long)mean * totalcnt)-sum;
        int ans[]=new  int[n];;
        if(reqsum<(long)n || reqsum>(6*(long)n))
            return new int[0];
        for(int i=0;i<n;i++)
        {
            if(reqsum-6 >= (long)(n-i-1))
            {
                ans[i]=6;
                reqsum-=6;
            }
            else if(reqsum-5 >= (long)(n-i-1))
            {
                ans[i]=5;
                reqsum-=5;
            }
            else if(reqsum-4 >= (long)(n-i-1))
            {
                ans[i]=4;
                reqsum-=4;
            }
            else if(reqsum-3 >= (long)(n-i-1))
            {
                ans[i]=3;
                reqsum-=3;
            }
            else if(reqsum-2 >= (long)(n-i-1))
            {
                ans[i]=2;
                reqsum-=2;
            }
            else
            {
                ans[i]=1;
                reqsum-=1;
            }
        }
        return ans;
    }
}