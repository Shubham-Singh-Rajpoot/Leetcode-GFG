class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        String temp;
        int i;
        for(i=0;i<=Integer.parseInt(nums[nums.length-1],2);i++)
        {
            temp=Integer.toBinaryString(i);
            if(temp.length()!=nums[0].length())
            {
                StringBuilder req=new  StringBuilder();
                while(temp.length()+req.length()!=nums[0].length())
                    req.append('0');
                temp=req.toString()+temp;
            }
            if(!(temp.equals(nums[i])))
                return temp;
        }
        temp=Integer.toBinaryString(i);
        if(temp.length()!=nums[0].length())
        {
            StringBuilder req=new  StringBuilder();
            while(temp.length()+req.length()!=nums[0].length())
                req.append('0');
            temp=req.toString()+temp;
        }
        return temp;
    }
}