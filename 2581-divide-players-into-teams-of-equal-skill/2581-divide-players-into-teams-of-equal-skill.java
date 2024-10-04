class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long ans=skill[0]*(long)skill[skill.length-1];
        for(int i=1,j=skill.length-2;i<j;i++,j--)
        {
            if((skill[i]+skill[j])==(skill[i-1]+skill[j+1]))
                ans+=((long)skill[i]*(long)skill[j]);
            else
                return -1;
        }
        return ans;
    }
}