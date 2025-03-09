class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int i;
        int count=1;
        int ans=0;
        for(i=1;i<k;i++)
            if(colors[i]!=colors[i-1])
                count++;
            else
                count=1;
        if(count==k)
            ans++;
        for(i=k;i<(colors.length+k-1);i++)
        {
            if(colors[i%colors.length]!=colors[(i-1)%colors.length])
                count++;
            else
                count=1;
            if(count>=k)
                ans++;
        }
        return ans;
    }
}