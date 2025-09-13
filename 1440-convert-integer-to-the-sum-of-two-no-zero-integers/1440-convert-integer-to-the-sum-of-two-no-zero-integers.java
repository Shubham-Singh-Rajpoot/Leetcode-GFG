class Solution {
    public int[] getNoZeroIntegers(int n)
    {
        for(int i=1;i<n;i++)
        {
            if(isnz(i) && isnz(n-i))
                return new int[]{i,n-i};
        }
        return new int[]{};
    }
    public boolean isnz(int n)
    {
        if((""+n).indexOf('0')==-1)
            return true;
        return false;
    }
}