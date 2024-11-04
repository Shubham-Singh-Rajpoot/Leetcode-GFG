class Solution {
    public String compressedString(String word) {
        StringBuilder comp=new  StringBuilder();
        char ch=word.charAt(0);
        int count=1;
        for(int i=1;i<word.length();i++)
        {
            if(word.charAt(i)!=ch || count==9)
            {
                comp.append(count);
                comp.append(ch);
                ch=word.charAt(i);
                count=1;
            }
            else
                count++;
        }
        comp.append(count);
        comp.append(ch);
        return comp.toString();
    }
}