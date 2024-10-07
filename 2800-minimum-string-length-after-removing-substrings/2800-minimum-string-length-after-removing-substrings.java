class Solution {
    public int minLength(String s)
    {
        int size=s.length();
        while(true)
        {
            s=s.replaceAll("AB","");
            s=s.replaceAll("CD","");
            if(size==s.length())
                break;
            size=s.length();
        }
        return s.length();
    }
}