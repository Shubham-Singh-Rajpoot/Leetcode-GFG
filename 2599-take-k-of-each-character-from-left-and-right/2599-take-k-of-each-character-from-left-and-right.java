class Solution {
    public int takeCharacters(String s, int k) {
        
        int[] a=new int[3];
        char[] c=s.toCharArray();
        int l=0,r=s.length()-1,ans=Integer.MAX_VALUE;
        while(l<=r)
        {
            if(l==r)
            {   
                a[c[l]-'a']++;
                l++;
            }
            else
            {
                a[c[l]-'a']++;
                l++;
                a[c[r]-'a']++;
                r--;
            }
        }
        if(Math.min(a[0],Math.min(a[1],a[2]))<k)
            return -1;
        l=0;
        r=0;
        while(r<s.length())
        {
            a[c[r]-'a']--;
            while(Math.min(a[0],Math.min(a[1],a[2]))<k)
            {
                a[c[l]-'a']++;
                l++;
            }
            ans = Math.min(ans,s.length()-(r-l+1));
            r++;
        }
        return ans;
    }
}