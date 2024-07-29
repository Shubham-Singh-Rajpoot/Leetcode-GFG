class Solution {
    public int maxProfit(int[] prices)
    {
        int max[]=new  int[prices.length];
        max[prices.length-1]=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--)
            max[i]=Math.max(prices[i],max[i+1]);
        int ans=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++)
        {
            min=Math.min(min,prices[i]);
            ans=Math.max(ans,max[i]-min);
        }
        return ans;
    }
}