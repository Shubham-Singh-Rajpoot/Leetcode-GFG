class Solution {
    public int[] sumZero(int n)
    {
        int ar[]=new int[n];
        int sum=0;
        for(int i=1;i<n;i++)
        {
            sum+=i;
            ar[i-1]=i;
        }
        ar[n-1]=sum*-1;
        return ar;
    }
}