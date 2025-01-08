class Solution {
    public int countPrefixSuffixPairs(String[] words)
    {
        int ans=0;
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                StringBuilder str=new  StringBuilder(words[j]);
                if(str.indexOf(words[i])==0 && (str.lastIndexOf(words[i])==(str.length()-words[i].length())))
                    ans++;
            }
        }
        return ans;
    }
}