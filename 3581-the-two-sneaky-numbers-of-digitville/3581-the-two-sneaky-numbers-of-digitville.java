class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int ans[]=new  int[2];
        int freq[]=new  int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++)
        {
            if(k==2)
                break;
            freq[nums[i]]++;
            if(freq[nums[i]]>1)
                ans[k++]=nums[i];
        }
        return ans;
    }
}