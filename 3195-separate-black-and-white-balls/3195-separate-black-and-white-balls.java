class Solution {
    public long minimumSteps(String s)
    {
        long ans=0;
        int k=s.length()-1;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                ans+=(k-i);
                k--;
            }
        }    
        return ans;    
    }
}