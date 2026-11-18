class Solution {
    public int minChanges(String s)
    {
        int count=1;
        char ch=s.charAt(0);
        int ans=0;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=ch)
            {
                if(count%2==0)
                {
                    ch=s.charAt(i);
                    count=1;
                }
                else
                {
                    count++;
                    ans++;
                }
            }
            else
                count++;
        }
        if(count%2!=0)
            ans++;
        return ans;
    }
}