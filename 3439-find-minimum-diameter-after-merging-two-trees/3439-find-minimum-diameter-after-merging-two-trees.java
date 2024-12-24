class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1,int[][] edges2)
    {
        List<Integer>[] adList1=buildAdList(edges1);
        List<Integer>[] adList2=buildAdList(edges2);
        int d1=getTreeDiameter(adList1);
        int d2=getTreeDiameter(adList2);
        return Math.max(Math.max(d1,d2),1+Math.ceilDiv(d1,2)+Math.ceilDiv(d2,2));
    }
    private List<Integer>[] buildAdList(int[][] edges)
    {
        if (edges.length == 0)
            return null;
        List<Integer>[] adList = new List[edges.length + 1];
        for (int i = 0; i < adList.length; i++) adList[i] = new ArrayList<>();
        for (int[] edge : edges)
        {
            adList[edge[0]].add(edge[1]);
            adList[edge[1]].add(edge[0]);
        }
        return adList;
    }
    private int getTreeDiameter(List<Integer>[] adList)
    {
        if (adList == null || adList.length == 0)
            return 0;
        int[] maxPath = new int[1];
        getTreeDiameterDFS(adList, 0, -1, maxPath);
        return maxPath[0];
    }
    private int getTreeDiameterDFS(List<Integer>[] adList, int node, int parent, int[] maxPath)
    {
        int max1 = 0, max2 = 0;
        int branchLength;
        for(int neighbor : adList[node])
        {
            if(neighbor == parent)
                continue;
            branchLength = getTreeDiameterDFS(adList, neighbor, node, maxPath);
            if(branchLength > max1)
            {
                max2 = max1;
                max1 = branchLength;
            }
            else if(branchLength > max2)
                max2 = branchLength;
        }
        maxPath[0] = Math.max(maxPath[0], max1 + max2);
        return max1 + 1;
    }
}