class Solution {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> set=new  HashSet<>();
        for(int i=0;i<=n-1;i++)
            set.add(i);
        for(int i=0;i<edges.length;i++)
            set.remove(edges[i][1]);
        if(set.size()==1)
            return set.iterator().next();
        return -1;
    }
}