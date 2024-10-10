class Solution {
    public int maxWidthRamp(int[] nums) {
        int n=nums.length;
        int[] maxOnRight=new int[n];
        int max=0;
        for(int i=n-1;i>=0;i--){
            maxOnRight[i]=Math.max(max,nums[i]);
            max= maxOnRight[i];
        }
        int result=0,left=0;
        for(int right=0;right<n;right++){
            while(nums[left]>maxOnRight[right])left++;
            result=Math.max(result,right-left);
        }
        return result;
    }
}