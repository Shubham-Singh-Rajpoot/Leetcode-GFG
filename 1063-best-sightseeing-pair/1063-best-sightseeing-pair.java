class Solution {
    public int maxScoreSightseeingPair(int[] values)
    {
        int maxi=Integer.MIN_VALUE;
        int left=values[0];
        for(int j=1;j<values.length;j++)
        {
            maxi=Math.max(maxi,left+values[j]-j);
            left=Math.max(left,values[j]+j);
        }
        return maxi;
    }
}