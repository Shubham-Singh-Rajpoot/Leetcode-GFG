class Solution {
    public int[] queryResults(int limit, int[][] queries)
    {
        HashMap<Integer,Integer> map=new  HashMap<>();
        HashMap<Integer,Integer> ar=new  HashMap<>();
        int ans[]=new  int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            if(ar.containsKey(queries[i][0]))
            {
                map.put(ar.get(queries[i][0]),map.get(ar.get(queries[i][0]))-1);
                if(map.get(ar.get(queries[i][0]))==0)
                    map.remove(ar.get(queries[i][0]));
            }
            ar.put(queries[i][0],queries[i][1]);
            map.put(queries[i][1],map.getOrDefault(queries[i][1],0)+1);
            ans[i]=map.size();
        }
        return ans;
    }
}