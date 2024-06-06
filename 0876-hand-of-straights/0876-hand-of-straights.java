class Solution
{
    public boolean isNStraightHand(int[] hand, int groupSize)
    {
        if(hand.length%groupSize!=0)
            return false;
        Arrays.sort(hand);
        int cc;
        int ld,j;
        List<Integer> list=new  ArrayList<>();
        for(int i=0;i<hand.length;i++)
            list.add(hand[i]);
        while(list.size()!=0)
        {
            cc=1;
            ld=list.remove(0);
            for(j=0;j<list.size() && cc<groupSize;j++)
            {
                if(list.get(j)==ld+1)
                {
                    ld++;
                    list.remove(j);
                    j-=1;
                    cc++;
                }
            }
            if(j==list.size() && cc<groupSize)
                return false;
        }
        return true;
    }
}