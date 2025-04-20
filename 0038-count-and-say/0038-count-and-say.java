class Solution {
    public String countAndSay(int n) {
        String s="1";int i,count=1;
        String temp="";
        char ch;
        while(n>1)
        {
            ch=s.charAt(0);
            i=1;
            count=1;
            while(i<s.length())
            {
                if(s.charAt(i)==ch)
                    count++;
                else
                {
                    temp=temp+count+ch;
                    ch=s.charAt(i);
                    count=1;
                }
                i++;
            }
            temp=temp+count+ch;
            s=temp;
            temp="";
            n--;
        }
        return s;
    }
}