class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries)
    {
        int n=heights.length,q=queries.length;
        int[] result=new int[q];
        Arrays.fill(result,-1);
        List<List<int[]>> queryStore=new ArrayList<>();
        for(int i=0;i<n;i++)
            queryStore.add(new ArrayList<>());
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a, b)->a[0]-b[0]);
        for (int i=0;i<q;i++)
        {
            int a=queries[i][0],b=queries[i][1];
            if (a == b || (a<b && heights[a]<heights[b]) || (a>b && heights[a]>heights[b]))
                result[i]=Math.max(a,b);
            else
            {
                int maxHeight=Math.max(heights[a],heights[b]);
                queryStore.get(Math.max(a,b)).add(new int[]{maxHeight,i});
            }
        }
        for(int i=0;i<n;i++)
        {
            while(!maxHeap.isEmpty() && maxHeap.peek()[0]<heights[i])
                result[maxHeap.poll()[1]]=i;
            for (int[] query:queryStore.get(i))
                maxHeap.offer(query);
        }
        return result;
    }
}