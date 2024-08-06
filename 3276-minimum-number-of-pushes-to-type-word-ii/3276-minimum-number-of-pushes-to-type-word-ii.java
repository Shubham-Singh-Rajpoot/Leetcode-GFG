class Solution {
    public int minimumPushes(String word)
    {
        int ar[]=new  int[26];
        for(int i=0;i<word.length();i++)
            ar[word.charAt(i)-97]++;
        Arrays.sort(ar);
        int mul=1;
        int count=1;
        int ans=0;
        for(int i=25;i>=0;i--)
        {
            ans+=mul*ar[i];
            if(count==8)
            {
                count=1;
                mul++;
            }
            else
                count++;
        }
        return ans;
    }
}