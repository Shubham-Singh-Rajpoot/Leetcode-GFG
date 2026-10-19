class Solution {
    public List<Integer> targetIndices(int[] nums, int target)
    {
        ArrayList<Integer> ar=new  ArrayList<Integer>();
        Arrays.sort(nums);
        int i,k=0;
        for(i=0;i<nums.length;i++)
            if(nums[i]==target)
                ar.add(k++,i);
        return ar;
    }
}