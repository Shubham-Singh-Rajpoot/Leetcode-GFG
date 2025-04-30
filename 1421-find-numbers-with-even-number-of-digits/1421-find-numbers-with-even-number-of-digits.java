class Solution {
    private boolean checklength(int num){
        int cnt=0;
        while(num>0){
            num/=10;
            cnt++;
        }
        if(cnt%2==0){
            return true;
        } 
      return false;
    }
    public int findNumbers(int[] nums) {
        int count=0;
        for(int n : nums){
            if(checklength(n)){
                count++;
            }
        }

        return count;
    }
}