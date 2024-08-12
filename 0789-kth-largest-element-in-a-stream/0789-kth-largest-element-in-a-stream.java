class KthLargest
{
    List<Integer> list=new  ArrayList<>();
    int k;
    public KthLargest(int k, int[] nums)
    {
        this.k=k;
        for(int i:nums)
            list.add(i);
        Collections.sort(list);
    }
    
    public int add(int val)
    {
        int i;
        for(i=0;i<list.size();i++)
            if(list.get(i)>=val)
                break;
        list.add(i,val);
        return list.get(list.size()-k); 
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */