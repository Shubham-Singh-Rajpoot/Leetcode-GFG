class Solution
{
    public char findKthBit(int n, int k)
    {
        if(n==1)
            return '0';
        return traverse(n,k,1,new StringBuilder("0"));
    }
    public char traverse(int n,int k,int i,StringBuilder s)
    {
        // System.out.println(n+" "+k+" "+i+" "+s);
        if(i==n)
            return s.charAt(k-1);
        s.append('1'+reverseinvert(s.toString()));
        return traverse(n,k,i+1,s);
    }
    public String reverseinvert(String s)
    {
        StringBuilder str=new  StringBuilder();
        for(int i=s.length()-1;i>=0;i--)
            str.append((s.charAt(i)=='0')?'1':'0');
        return str.toString();
    }
}