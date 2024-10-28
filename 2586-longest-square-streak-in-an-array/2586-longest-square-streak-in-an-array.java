class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> unqNums = new HashSet<>();
        for(var num : nums){
            unqNums.add(num * 1l);
        }
        int maxSSLen = 0;
        for(var num : nums){
            int currSSLen = 1;
            long currNum = num * 1l;
            while(unqNums.contains(currNum * currNum)){
                currSSLen++;
                currNum = currNum * currNum;
            }
            maxSSLen = Math.max(maxSSLen, currSSLen);
        }
        return maxSSLen == 1 ? -1 :  maxSSLen;
    }
}