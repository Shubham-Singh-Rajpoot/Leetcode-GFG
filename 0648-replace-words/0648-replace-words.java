class Solution
{
    public String replaceWords(List<String> dictionary, String sentence)
    {
        HashSet<String> set=new HashSet<>(dictionary);
        sentence+=" ";
        String temp;
        StringBuilder str=new  StringBuilder(sentence);
        int start=0,end=0;
        while(start<str.length())
        {
            if(str.charAt(start)==' ')
            {
                start++;
                end=start;
                if(start==str.length())
                    break;
            }
            if(str.charAt(end)==' ')//word not found in dictionary
            {
                start=end+1;
                end++;
                continue;
            }
            temp=str.substring(start,end+1);
            if(set.contains(temp))
            {
                while(str.charAt(end)!=' ')
                    end++;
                str.replace(start,end,temp);
                while(str.charAt(start)!=' ')
                    start++;
                end=start;
            }
            end++;
        }
        return str.substring(0,str.length()-1);
    }
}