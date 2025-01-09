class Solution {
    public int prefixCount(String[] words, String pref)
    {
        int ans=0;
        for(int i=0;i<words.length;i++)
        {
            StringBuilder str=new  StringBuilder(words[i]);
            if(str.indexOf(pref)==0)
                ans++;
        }
        return ans;
    }
}