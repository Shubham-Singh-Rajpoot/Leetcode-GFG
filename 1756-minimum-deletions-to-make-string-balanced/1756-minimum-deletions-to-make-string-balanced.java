class Solution {
    public int minimumDeletions(String s)
    {
        int ans=Integer.MAX_VALUE;
        int posa[]=new  int[s.length()];
        if(s.charAt(s.length()-1)=='a')
            posa[s.length()-1]++;
        for(int i=s.length()-2;i>=0;i--)
        {
            posa[i]=posa[i+1];
            if(s.charAt(i)=='a')
                posa[i]++;
        }
        int cntb=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='b')
                cntb++;
            ans=Math.min(ans,posa[i]+cntb-1);
        }
        return ans;
    }
}