class Solution {
    public int maxSubarrayLength(int[] nums, int k)
    {
        HashMap<Integer,Integer> map=new  HashMap<>();
        int start=0,maxl=1;
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>k)
            {
                maxl=Math.max(maxl,(i-start));
                while(map.get(nums[i])>k)
                {
                    map.put(nums[start],map.get(nums[start])-1);
                    if(map.get(nums[start])==0)
                        map.remove(nums[start]);
                    start++;
                }
            }
        }
        maxl=Math.max(maxl,nums.length-start);
        return maxl;
    }
}