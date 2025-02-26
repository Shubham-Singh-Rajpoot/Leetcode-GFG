class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int npresum = 0,ppresum = 0,posmx = 0,negmax = 0;
        for(int x:nums){
            ppresum += x;
            npresum += x;
            if(ppresum<=0){
                ppresum = 0;
                negmax = Math.min(negmax,npresum);  
            }
            if(npresum>=0){
                npresum = 0;
                posmx = Math.max(posmx,ppresum);
            }  
        }
        return Math.max(posmx,-negmax);
    }
}