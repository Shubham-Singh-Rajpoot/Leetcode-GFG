class Solution {
    public String removeOuterParentheses(String s) {
        int i,counter=0;
        String s2="";
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                counter++;
            else
                counter--;
            if(counter==0)
            {
                s2=s2+s.substring(1,i);
                s=s.substring(i+1);
                i=-1;
            }
        }
        return s2;
    }
}