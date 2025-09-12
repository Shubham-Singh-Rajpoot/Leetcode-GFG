class Solution {
    public String sortVowels(String s)
    {
        HashSet<Character> set=new  HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        StringBuilder str=new  StringBuilder();
        for(int i=0;i<s.length();i++)
            if(set.contains(s.charAt(i)))
                str.append(s.charAt(i));
        char vow[]=str.toString().toCharArray();
        Arrays.sort(vow);
        int curr=0;
        StringBuilder ans=new  StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(set.contains(s.charAt(i)))
            {
                ans.append(vow[curr]);
                curr++;
            }
            else
                ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}