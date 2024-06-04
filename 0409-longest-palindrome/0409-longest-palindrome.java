class Solution
{
    public int longestPalindrome(String s)
    {
        HashSet<Character> set=new  HashSet<>();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(set.contains(s.charAt(i)))
            {
                set.remove(s.charAt(i));
                ans+=2;
            }
            else
                set.add(s.charAt(i));
        }
        if(set.size()==0)
            return ans;
        else
            return ans+1;
    }
}