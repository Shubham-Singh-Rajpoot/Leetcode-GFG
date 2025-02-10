class Solution {
    public String clearDigits(String s)
    {
        List<Character> list=new  ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>=48 && s.charAt(i)<=57)
            {
                if(list.size()!=0 && (list.get(list.size()-1)<48 || list.get(list.size()-1)>57))
                    list.remove(list.size()-1);
                else
                    continue;
            }
            else
                list.add(s.charAt(i));
        }
        StringBuilder ans=new  StringBuilder();
        for(char ch:list)
            ans.append(ch);
        return ans.toString();
    }
}