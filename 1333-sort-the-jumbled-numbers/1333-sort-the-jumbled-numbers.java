class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums)
    {
        HashMap<Integer,List> org=new  HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            String num=""+nums[i];
            int ans=0;
            for(int j=0;j<num.length();j++)
                ans=(ans*10)+mapping[(num.charAt(j)-48)];
            List<Integer> temp=org.getOrDefault(ans,new  ArrayList<>());
            temp.add(nums[i]);
            org.put(ans,temp);
            nums[i]=ans;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            List<Integer> temp=org.get(nums[i]);
            int val=temp.get(0);
            temp.remove(0);
            org.put(nums[i],temp);
            nums[i]=val;
        }
        return nums;
    }
}