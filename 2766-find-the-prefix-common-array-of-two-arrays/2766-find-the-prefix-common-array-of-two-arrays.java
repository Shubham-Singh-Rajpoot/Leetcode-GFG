class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B)
    {
        int c[]=new  int[A.length];
        HashMap<Integer,Integer> map=new  HashMap<>();
        int ans=0;
        for(int i=0;i<A.length;i++)
        {
            map.put(A[i],map.getOrDefault(A[i],0)+1);
            if(map.get(A[i])%2==0)
                ans++;
            map.put(B[i],map.getOrDefault(B[i],0)+1);
            if(map.get(B[i])%2==0)
                ans++;
            c[i]=ans;
        }
        return c;
    }
}