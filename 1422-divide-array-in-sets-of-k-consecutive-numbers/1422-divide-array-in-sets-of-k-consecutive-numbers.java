class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0)
            return false;
        Arrays.sort(nums);
        int cc;
        int ld,j;
        List<Integer> list=new  ArrayList<>();
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        while(list.size()!=0)
        {
            cc=1;
            ld=list.remove(0);
            for(j=0;j<list.size() && cc<k;j++)
            {
                if(list.get(j)==ld+1)
                {
                    ld++;
                    list.remove(j);
                    j-=1;
                    cc++;
                }
            }
            if(j==list.size() && cc<k)
                return false;
        }
        return true;
    }
}