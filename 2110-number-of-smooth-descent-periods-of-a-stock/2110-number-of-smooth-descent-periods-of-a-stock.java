class Solution {
    public long getDescentPeriods(int[] prices) {
        if(prices.length==1)
            return 1;
        long ans=0;
        for(int i=0;i<prices.length;i++)
        {
            int j=i;
            for(j=i+1;j<prices.length && prices[j-1]-prices[j]==1;j++)
            {}
            j=j-1;
            ans=ans+((((long)(j-i)+1)*((long)(j-i)+2))/2);
            i=j;
        }
        return ans;
    }
}