class Solution {
    public double averageWaitingTime(int[][] customers) {
        double wt=0;
        int time=0;
        for(int i=0;i<customers.length;i++)
        {
            if(time>=customers[i][0])
                time+=customers[i][1];
            else
                time=customers[i][0]+customers[i][1];
            wt+=(time-customers[i][0]);
        }
        return wt/customers.length;
    }
}