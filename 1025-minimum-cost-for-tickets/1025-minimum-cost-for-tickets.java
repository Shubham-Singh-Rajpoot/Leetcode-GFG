class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new  int[days.length];
        Arrays.fill(dp,-1);
        return traverse(days,costs,dp,0);
    }
    public int traverse(int days[],int costs[],int dp[],int index)
    {
        if(index>=days.length)
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        int temp1=costs[0]+traverse(days,costs,dp,index+1);
        int i=index;
        while(i<days.length && days[i]-days[index]<7)
            i++;
        int temp2=costs[1]+traverse(days,costs,dp,i);
        i=index;
        while(i<days.length && days[i]-days[index]<30)
            i++;
        int temp3=costs[2]+traverse(days,costs,dp,i);
        return dp[index]=Math.min(temp1,Math.min(temp2,temp3));
    }
}