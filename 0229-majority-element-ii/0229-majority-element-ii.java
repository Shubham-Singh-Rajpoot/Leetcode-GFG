class Solution {
    public List<Integer> majorityElement(int[] nums)
    {
        int i,x=Integer.MIN_VALUE,y=Integer.MIN_VALUE,xc=0,yc=0;
        for(i=0;i<nums.length;i++)
        {
            if(x!=Integer.MIN_VALUE&&x==nums[i])
            {
                xc+=1;
            }
            else if(y!=Integer.MIN_VALUE&&y==nums[i])
            {
                yc+=1;
            }
            else if(xc==0)
            {
                x=nums[i];
                xc+=1;
            }
            else if(yc==0)
            {
                y=nums[i];
                yc+=1;
            }
            else
            {
                xc-=1;
                yc-=1;
            }
        }
        xc=0;
        yc=0;
        for(i=0;i<nums.length;i++)
        {
            if(x!=Integer.MIN_VALUE && x==nums[i])
                xc+=1;
            if(y!=Integer.MIN_VALUE && y==nums[i])
                yc+=1;
        }
        List<Integer> ar = new ArrayList<Integer>();
        if(xc>(nums.length/3))
            ar.add(x);
        if(yc>(nums.length/3))
            ar.add(y);
        return ar;
    }
}