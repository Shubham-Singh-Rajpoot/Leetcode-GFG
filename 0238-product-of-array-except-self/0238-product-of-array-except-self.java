class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre[]=new  int[nums.length];
        int post[]=new int[nums.length];
        Arrays.fill(pre,1);
        Arrays.fill(post,1);
        pre[0]=nums[0];
        post[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++)
        {
            pre[i]=pre[i-1]*nums[i];
            post[nums.length-i-1]=post[nums.length-i]*nums[nums.length-i-1];
        }
        int ans[]=new int[nums.length];
        ans[0]=post[1];
        ans[nums.length-1]=pre[nums.length-2];
        for(int i=1;i<nums.length-1;i++)
            ans[i]=pre[i-1]*post[i+1];
        return ans;
    }
}