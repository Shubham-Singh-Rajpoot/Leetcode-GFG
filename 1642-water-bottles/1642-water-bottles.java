class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        int empty=ans;
        while(empty>=numExchange)
        {
            numBottles=empty/numExchange;
            empty%=numExchange;
            ans+=numBottles;
            empty+=numBottles;
        }
        return ans;
    }
}