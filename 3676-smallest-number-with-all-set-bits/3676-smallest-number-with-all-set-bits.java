class Solution {
    public int smallestNumber(int n)
    {
        int i=0;
        for(i=1;(int)Math.pow(2,i)-1<n;i++)
        {}
        return (int)Math.pow(2,i)-1;
    }
}