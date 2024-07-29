class Solution {
    public int maxProfit(int[] prices)
    {
        int min[]=new  int[prices.length];
        int max[]=new  int[prices.length];
        min[0]=prices[0];
        max[prices.length-1]=prices[prices.length-1];
        for(int i=1;i<prices.length;i++)
        {
            min[i]=Math.min(prices[i],min[i-1]);
            max[prices.length-1-i]=Math.max(prices[prices.length-1-i],max[prices.length-i]);
        }
        int ans=0;
        for(int i=0;i<prices.length;i++)
            ans=Math.max(ans,max[i]-min[i]);
        return ans;
    }
}