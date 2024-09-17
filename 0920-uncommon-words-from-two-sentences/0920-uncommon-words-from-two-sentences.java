class Solution {
    public String[] uncommonFromSentences(String s1, String s2)
    {
        s1=s1+" ";
        s2=s2+" ";
        HashSet<String> occured=new  HashSet<>();
        HashSet<String> unique=new  HashSet<>();
        StringBuilder str=new  StringBuilder();
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==' ')
            {
                helper(str.toString(),occured,unique);
                str.setLength(0);
            }
            else
                str.append(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++)
        {
            if(s2.charAt(i)==' ')
            {
                helper(str.toString(),occured,unique);
                str.setLength(0);
            }
            else
                str.append(s2.charAt(i));
        }
        return unique.toArray(new String[0]);
    }
    public void helper(String word,HashSet<String> occ,HashSet<String> un)
    {
        if(occ.contains(word))
            return;
        if(un.contains(word))
        {
            un.remove(word);
            occ.add(word);
        }
        else
            un.add(word);
    }
}