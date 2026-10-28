class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][][] dp = new boolean[n][m][1024];
        dp[0][0][grid[0][0]] = true;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<1024;k++) {
                    if(!dp[i][j][k]) continue;
                    // Move Right
                    if (j+1<m) {
                        dp[i][j+1][k^grid[i][j+1]] = true;
                    }
                    // Move Down
                    if (i+1<n) {
                        dp[i+1][j][k^grid[i+1][j]] = true;
                    }
                }
            }
        }
        for(int k=0;k<1024;k++){
            if(dp[n-1][m-1][k]) return k;
        }
        return -1;
    }
}