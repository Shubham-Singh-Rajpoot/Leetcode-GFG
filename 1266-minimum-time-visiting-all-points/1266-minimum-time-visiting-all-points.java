class Solution {
    public int minTimeToVisitAllPoints(int[][] points)
    {
        int x=points[0][0];
        int y=points[0][1];
        int time=0;
        for(int i=1;i<points.length;i++)
        {
            //MOVE DIAGONALLY TOP RIGHT
            while(points[i][0]>x && points[i][1]>y)
            {
                x++;
                y++;
                time++;
            }
            //MOVE DIAGONALLY TOP LEFT
            while(points[i][0]<x && points[i][1]>y)
            {
                x--;
                y++;
                time++;
            }
            //MOVE DIAGONALLY BOTTOM LEFT
            while(points[i][0]<x && points[i][1]<y)
            {
                x--;
                y--;
                time++;
            }
            //MOVE DIAGONALLY BOTTOM RIGHT
            while(points[i][0]>x && points[i][1]<y)
            {
                x++;
                y--;
                time++;
            }
            //MOVE LEFT
            while(points[i][0]<x && points[i][1]==y)
            {
                x--;
                time++;
            }
            //MOVE RIGHT
            while(points[i][0]>x && points[i][1]==y)
            {
                x++;
                time++;
            }
            //MOVE UP
            while(points[i][0]==x && points[i][1]>y)
            {
                y++;
                time++;
            }
            //MOVE DOWN
            while(points[i][0]==x && points[i][1]<y)
            {
                y--;
                time++;
            }
        }
        return time;
    }
}