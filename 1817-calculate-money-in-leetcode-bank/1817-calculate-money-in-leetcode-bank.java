class Solution {
    public int totalMoney(int n)
    {
        int ar[]={1,2,3,4,5,6,7};
        int index=0;
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans+=ar[index];
            ar[index]++;
            index=(index+1)%7;
        }
        return ans;
    }
}