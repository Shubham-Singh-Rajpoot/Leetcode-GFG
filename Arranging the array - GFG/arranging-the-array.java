//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
        List<Integer> list1=new  ArrayList<>();
        List<Integer> list2=new  ArrayList<>();
        int i,k,temp;
        for(i=0;i<a.length;i++)
        {
            if(a[i]<0)
                list1.add(a[i]);
            else
                list2.add(a[i]);
        }
        for(i=0;i<list1.size();i++)
            a[i]=list1.get(i);
        for(i=0;i<list2.size();i++)
            a[list1.size()+i]=list2.get(i);
    }
}