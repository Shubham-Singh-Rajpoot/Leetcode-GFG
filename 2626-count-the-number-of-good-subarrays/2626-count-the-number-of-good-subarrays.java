class Solution {
    public long countGood(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;

        Map<Integer, Integer > mp = new HashMap<>();
        long pairCount = 0;
        long ansCount = 0;
        while(right<n){
            mp.put(nums[right],mp.getOrDefault(nums[right],0)+1);
            pairCount+=mp.get(nums[right])-1;
               
            while(pairCount>=k){
                ansCount+=(n-right);
                int leftCnt = mp.get(nums[left]);
                if(leftCnt>1){
                    pairCount-= leftCnt-1;
                    mp.put(nums[left],mp.get(nums[left])-1);
                }else mp.remove(nums[left]);
                left++;
            }
            right++;
        }

        return ansCount;
    }
}
