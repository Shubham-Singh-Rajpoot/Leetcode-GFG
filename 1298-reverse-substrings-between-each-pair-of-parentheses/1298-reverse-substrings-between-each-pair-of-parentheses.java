class Solution {
    public String reverseParentheses(String s)
    {
        List<StringBuilder> list=new  ArrayList<>();
        StringBuilder temp=new  StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(temp.length()!=0)
                    list.add(temp);
                temp=new  StringBuilder("");
                list.add(new  StringBuilder("("));
            }
            else if(s.charAt(i)>=97 && s.charAt(i)<=122)
                temp.append(s.charAt(i));
            else
            {
                if(temp.length()!=0)
                    list.add(temp);
                temp=new  StringBuilder();
                int j=list.size()-1;
                while(j>=0 && !list.get(j).toString().equals("("))
                    j--;
                if(j!=-1)
                {
                    list.remove(j);
                    for( ;j!=list.size(); )
                    {
                        temp.append(list.get(j));
                        list.remove(j);
                    }
                    list.add(new  StringBuilder(temp.reverse()));
                    temp=new StringBuilder();
                }
                else
                {
                    j=0;
                    for( ;j!=list.size(); )
                    {
                        temp.append(list.get(j));
                        list.remove(j);
                    }
                    list.add(temp);
                }
            }
        }
        if(temp.length()!=0)
            list.add(temp);
        temp=new  StringBuilder();
        for(int i=0;i<list.size();i++)
            temp.append(list.get(i));
        return temp.toString();
    }
}