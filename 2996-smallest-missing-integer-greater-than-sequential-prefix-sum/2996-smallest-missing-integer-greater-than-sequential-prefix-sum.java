class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set=new  HashSet<>();
        for(int i:nums)
            set.add(i);
        int sum=nums[0];
        int i=1;
        while(i<nums.length && nums[i]==(nums[i-1]+1))
        {
            sum+=nums[i];
            i++;
        }
        if(set.contains(sum))
            while(set.contains(sum))
                sum++;
        return sum;
    }
}