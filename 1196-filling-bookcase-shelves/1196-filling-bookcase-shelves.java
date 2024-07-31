class Solution {
    int[][] dp;
    public int minHeightShelves(int[][] books,int shelfWidth)
    {
        int n=books.length;
        this.dp=new int[n][shelfWidth+1];
        return traverse(books,shelfWidth,0,0,0);
    }

    public int traverse(int[][] books,int shelfwidth,int csh,int cw,int n)
    {
        if(n== books.length)
            return 0;
        if(dp[n][cw]!=0)
            return dp[n][cw];
        int nextshelf=books[n][1]+traverse(books,shelfwidth,books[n][1],books[n][0],n+1);
        int sameshelf=Integer.MAX_VALUE;
        if(shelfwidth>=cw+books[n][0])
            sameshelf=Math.max(books[n][1]-csh,0)+traverse(books,shelfwidth,Math.max(csh,books[n][1]),cw+books[n][0],n+1);
        return dp[n][cw]=Math.min(nextshelf,sameshelf);
    }
}