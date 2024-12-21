class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        int ar[]=new  int[256];
        int i,maxl=0,ws=0,we=-1;
        for(i=0;i<256;i++)
            ar[i]=-1;
        for(i=0;i<s.length();i++)
        {
            if(ar[s.charAt(i)]==-1)
            {
                ar[s.charAt(i)]=i;
                we++;
            }
            else if(ar[s.charAt(i)]!=-1&&ar[s.charAt(i)]<ws)
            {
                ar[s.charAt(i)]=i;
                we++;
            }
            else if(ar[s.charAt(i)]!=-1&&ar[s.charAt(i)]>=ws)
            {
                ws=ar[s.charAt(i)]+1;
                ar[s.charAt(i)]=i;
                we++;
            }
            if((we-ws+1)>maxl)
                maxl=we-ws+1;
        }
        return maxl;
    }
}