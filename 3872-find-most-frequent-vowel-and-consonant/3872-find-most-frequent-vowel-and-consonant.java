class Solution {
    public int maxFreqSum(String s) {
        int freq[]=new  int[26];
        for(int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        int mfvow=0;
        int mfcons=0;
        for(int i=0;i<26;i++)
        {
            if(i=='a'-'a' || i=='e'-'a' || i=='i'-'a' || i=='o'-'a' || i=='u'-'a')
            {
                if(mfvow<freq[i])
                    mfvow=freq[i];
            }
            else
            {
                if(mfcons<freq[i])
                    mfcons=freq[i];
            }
        }
        return mfvow+mfcons;
    }
}