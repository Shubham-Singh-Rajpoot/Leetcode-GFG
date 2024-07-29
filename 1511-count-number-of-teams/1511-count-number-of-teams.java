class Solution
{
    int large[];
    int small[];
    public int numTeams(int[] rating)
    {
        this.large=new  int[rating.length];
        this.small=new  int[rating.length];
        Arrays.fill(large,-1);
        Arrays.fill(small,-1);
        int ans=0;
        for(int j=1;j<rating.length-1;j++)
            for(int k=j+1;k<rating.length;k++)
            {
                if(rating[k]>rating[j])
                {
                    if(large[j]==-1)
                        large[j]=1;
                    else
                        large[j]++;
                }
                else
                {
                    if(small[j]==-1)
                        small[j]=1;
                    else
                        small[j]++;
                }
            }
        for(int i=0;i<rating.length-2;i++)
        {
            for(int j=i+1;j<rating.length-1;j++)
            {
                if(rating[j]>rating[i])
                    ans+=Math.max(large[j],0);
                else
                    ans+=Math.max(small[j],0);
            }
        }
        return ans;
    }
}