class Solution {
    public int numDecodings(String s)
    {
        int n=s.length();
        int tbl[]=new  int[n+1];
        Arrays.fill(tbl,Integer.MIN_VALUE);
        return f1(0,s,tbl);
    }
    public int f1(int i,String s,int[] tbl)
    {
        if(tbl[i]!=Integer.MIN_VALUE) return tbl[i];
        if(i==s.length()) return tbl[i]=1;
        if(i==s.length()-1)
            return tbl[i]=(s.charAt(i)>='1' && s.charAt(i)<='9')?1:0;
        tbl[i]=0;
        if(s.charAt(i) >='1' && s.charAt(i) <='9')
            tbl[i]+=f1(i+1,s,tbl);
        int val=10*(s.charAt(i)-'0')+(s.charAt(i+1)-'0');
        if(val >=10 && val<=26)
            tbl[i]+=f1(i+2,s,tbl);
        return tbl[i];
    }
}