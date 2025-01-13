class Solution {
    public int minimumLength(String s) {
        int ar[]=new  int[26];
        for(int i=0;i<s.length();i++)
            ar[s.charAt(i)-97]++;
        for(int i=0;i<26;i++)
        {
            while(ar[i]>=3)
                ar[i]-=2;
        }
        int ans=0;
        for(int i=0;i<26;i++)
            ans+=ar[i];
        return ans;
    }
}