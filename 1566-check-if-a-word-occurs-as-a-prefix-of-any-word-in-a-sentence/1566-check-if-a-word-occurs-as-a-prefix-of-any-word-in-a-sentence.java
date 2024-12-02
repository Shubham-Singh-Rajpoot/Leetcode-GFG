class Solution {
    public int isPrefixOfWord(String sentence, String searchWord)
    {
        int wc=0;
        for(int i=-1;i<sentence.length();i++)
        {
            if(i==-1 || sentence.charAt(i)==' ')
            {
                wc++;
                int j=0;
                for(j=0;(i+1+j)<sentence.length() && j<searchWord.length();j++)
                    if(sentence.charAt(i+1+j)!=searchWord.charAt(j))
                        break;
                if(j==searchWord.length())
                    return wc;
            }
        }
        return -1;
    }
}