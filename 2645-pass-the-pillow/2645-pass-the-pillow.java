class Solution {
    public int passThePillow(int n, int time) {
        time%=(n*2-2);
        if(time-(n-1) <= 0)
            return time+1;
        else
            time-=(n-1);
            return n-time;
    }
}