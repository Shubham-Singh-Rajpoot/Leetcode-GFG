class Solution {
    public boolean hasSameDigits(String s)
    {
        while(s.length()!=2)
        {
            StringBuilder temp=new  StringBuilder();
            for(int i=0;i<s.length()-1;i++)
                temp.append(((s.charAt(i)-48)+(s.charAt(i+1)-48))%10);
            s=temp.toString();
        }
        if(s.charAt(0)==s.charAt(1))
            return true;
        return false;
    }
}