class Solution {
    public int countCommas(int n)
    {
        int ans=0;
        for(int i=1000;i<=n;i++)
        {
            int num=i;
            int count=0;
            while(num!=0)
            {
                num/=10;
                count++;
            }
            ans+=((count-1)/3);
        }
        return ans;
    }
}