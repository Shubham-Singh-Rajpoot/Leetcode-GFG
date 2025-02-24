class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        HashSet<Integer> set=new  HashSet<>();
        for(int i=0;i<rooms.size();i++)
            set.add(i);
        ArrayList<Integer> ar=new  ArrayList<>();
        ar.add(0);
        while(set.size()!=0 && ar.size()!=0)
        {
            int size=ar.size();
            for(int i=0;set.size()!=0 && i<size;i++)
            {
                if(set.contains(ar.get(0)))
                {
                    set.remove(ar.get(0));
                    List<Integer> temp=rooms.get(ar.get(0));
                    for(int j=0;j<temp.size();j++)
                        ar.add(temp.get(j));
                }
                ar.remove(0);
            }
        }
        if(set.size()==0)
            return true;
        return false;
    }
}