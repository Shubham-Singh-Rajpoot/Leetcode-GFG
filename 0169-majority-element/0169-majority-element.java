class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new  HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            set.add(nums[i]);
        }
        Iterator<Integer> it=set.iterator();
        while(it.hasNext())
        {
            int key=it.next();
            if(map.get(key)>nums.length/2)
                return key;
        }
        return 0;
    }
}