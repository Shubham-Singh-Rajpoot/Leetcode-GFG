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
        for(int i=0;i<rating.length-2;i++)
        {
            for(int j=i+1;j<rating.length-1;j++)
            {
                if(rating[j]>rating[i])
                    ans+=(large[i]=traverse(rating,j,1));
                else
                    ans+=(small[i]=traverse(rating,j,0));
            }
        }
        return ans;
    }
    public int traverse(int[] rating,int i,int greater)
    {
        if(greater==0 && small[i]!=-1)
            return small[i];
        if(greater==1 && large[i]!=-1)
            return large[i];
        int ans=0;
        if(greater==1)
        {
            for(int j=i+1;j<rating.length;j++)
                if(rating[j]>rating[i])
                    ans+=1;
        }
        else
        {
            for(int j=i+1;j<rating.length;j++)
                if(rating[j]<rating[i])
                    ans+=1;
        }
        return ans;
    }
}