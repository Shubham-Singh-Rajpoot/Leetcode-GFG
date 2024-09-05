class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int fuel=0;
        for(int start=0;start<gas.length;start++)
        {
            int curr;
            fuel=gas[start]-cost[start];
            for(curr=(start+1)%gas.length;fuel>0&&curr!=start;curr=(curr+1)%gas.length)
            {
                fuel+=(gas[curr]-cost[curr]);
            }
            if(curr==start&&fuel>=0)
                return start;
            fuel=0;
        }
        return -1;
    }
}