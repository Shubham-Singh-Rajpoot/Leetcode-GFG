class Solution {
    public String makeFancyString(String s)
    {
        StringBuilder ans=new  StringBuilder();
        int occ=1;
        char ch=s.charAt(0);
        ans.append(ch);
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)!=ch)
            {
                ch=s.charAt(i);
                occ=1;
                ans.append(ch);
            }
            else
            {
                occ++;
                if(occ==2)
                    ans.append(ch);
                while(i+1<s.length() && s.charAt(i+1)==ch)
                    i++;
            }
        }
        return ans.toString();
    }
}