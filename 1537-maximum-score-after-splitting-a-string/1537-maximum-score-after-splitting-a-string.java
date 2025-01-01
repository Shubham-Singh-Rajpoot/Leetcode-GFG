class Solution {
    public int maxScore(String s) {
        int i,c0=0,c1=0,max=0;
        for(i=0;i<s.length();i++)
            if(s.charAt(i)=='1')
                c1+=1;
        for(i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='0')
                c0+=1;
            else
                c1-=1;
            max=Math.max(max,c0+c1);
        }
        return max;
    }
}