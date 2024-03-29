//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution2{
    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][]=new  int[N][N];
        for(int i=0;i<N;i++)
            Arrays.fill(dp[i],-1);
        return traverse(1,N-1,arr,dp);
    }
    static int traverse(int i,int j,int arr[],int dp[][])
    {
        if(i==j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int cost=traverse(i,k,arr,dp)+traverse(k+1,j,arr,dp)+(arr[i-1]*arr[k]*arr[j]);
            ans=Math.min(ans,cost);
        }
        return dp[i][j]=ans;
    }
}

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int dp[][]=new  int[N][N];
        for(int i=N-1;i>=1;i--)
        {
            for(int j=i+1;j<N;j++)
            {
                int ans=Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                {
                    int cost=dp[i][k]+dp[k+1][j]+(arr[i-1]*arr[k]*arr[j]);
                    ans=Math.min(ans,cost);
                }
                dp[i][j]=ans;
            }
        }
        return dp[1][N-1];
    }
}