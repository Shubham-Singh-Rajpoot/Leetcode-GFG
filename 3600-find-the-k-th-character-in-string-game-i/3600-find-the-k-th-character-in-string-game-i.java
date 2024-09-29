class Solution
{
    public char kthCharacter(int k)
    {
        int len=1;
        StringBuilder str=new  StringBuilder("a");
        while(str.length()<k)
        {
            len=str.length();
            for(int i=0;i<len && str.length()<k;i++)
                str.append((char)((((str.charAt(i)-97)+1)%26)+97));
        }
        return str.charAt(k-1);
    }
}