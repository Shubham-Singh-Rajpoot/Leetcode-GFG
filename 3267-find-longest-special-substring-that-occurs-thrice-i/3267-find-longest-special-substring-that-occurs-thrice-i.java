class Solution {
    public int maximumLength(String s)
    {
        int ans=-1;
        HashSet<String> occured=new  HashSet<>();
        for(int len=1;len<=s.length();len++)
        {
            for(int i=0;i<=s.length()-len;i++)
            {
                String temp=s.substring(i,i+len);
                if(!occured.contains(temp) && isSpecial(temp))
                {
                    occured.add(temp);
                    if(traverse(s,temp)==3)
                        ans=Math.max(ans,temp.length());
                }
            }
        }
        if(ans==0)
            return -1;
        return ans;
    }
    public int traverse(String s,String sub)
    {
        int occr=0;
        for(int i=0;i<=s.length()-sub.length();i++)
        {
            if(s.substring(i,i+sub.length()).equals(sub))
                occr++;
            if(occr==3)
                break;
        }
        return occr;
    }
    public boolean isSpecial(String s)
    {
        char ch=s.charAt(0);
        for(int i=1;i<s.length();i++)
            if(s.charAt(i)!=ch)
                return false;
        return true;
    }
}