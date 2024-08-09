class Solution {
    public int numMagicSquaresInside(int[][] grid)
    {
        int ans=0;
        for(int i=1;i<grid.length-1;i++)
            for(int j=1;j<grid[0].length-1;j++)
                if(checkValid(grid,i,j))
                    ans++;
        return ans;
    }
    public boolean checkValid(int grid[][],int i,int j)
    {
        HashSet<Integer> set=new  HashSet<>();
        int r1s=grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1];
        int r2s=grid[i][j-1]+grid[i][j]+grid[i][j+1];
        int r3s=grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1];
        int c1s=grid[i-1][j-1]+grid[i][j-1]+grid[i+1][j-1];
        int c2s=grid[i][j-1]+grid[i][j]+grid[i][j+1];
        int c3s=grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1];
        int d1s=grid[i-1][j-1]+grid[i][j]+grid[i+1][j+1];
        int d2s=grid[i-1][j+1]+grid[i][j]+grid[i+1][j-1];
        for(int p1=i-1;p1<=i+1;p1++)
            for(int p2=j-1;p2<=j+1;p2++)
            {
                if(set.contains(grid[p1][p2]) || grid[p1][p2]>9 || grid[p1][p2]==0)
                    return false;
                set.add(grid[p1][p2]);
            }
        if(r1s==r2s&&r2s==r3s&&r3s==d1s&&d1s==d2s&&d2s==c1s&&c1s==c2s&&c2s==c3s)
            return true;
        return false;
    }
}