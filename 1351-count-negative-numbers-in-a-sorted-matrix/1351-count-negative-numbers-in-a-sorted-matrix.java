class Solution {
    public int countNegatives(int[][] grid) 
    {
        int i,j,low,high,mid,cnt=0;
        for(i=0;i<grid.length;i++)
        {
            if(grid[i][0]<0)
                cnt+=grid[0].length;
            else if(grid[i][grid[i].length-1]>=0)
                cnt+=0;
            else
            {
                low=0;
                high=grid[i].length-1;
                mid=(high+low)/2;
                while(low<high)
                {
                    mid=(low+high)/2;
                    if(grid[i][mid]<0)
                        high=mid;
                    else
                        low=mid+1;
                }
                cnt+=(grid[i].length-low);
            }
        }
        return cnt;
    }
}