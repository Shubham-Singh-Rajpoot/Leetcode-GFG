class Solution {
    public int smallestChair(int[][] times, int targetFriend)
    {
        int ta=times[targetFriend][0];//target arrival
        PriorityQueue<Integer> pq=new  PriorityQueue<>();
        HashMap<Integer,List<Integer>> map=new  HashMap<>();
        Arrays.sort(times,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<times.length;i++)
            pq.add(i);
        int k=0;
        for(int i=times[0][0];i<=times[times.length-1][0];i++)
        {
            if(map.containsKey(i))
            {
                List<Integer> temp=map.get(i);
                for(int j:temp)
                    pq.add(j);
                map.remove(i);
            }
            if(i==ta)
                break;
            if(times[k][0]==i)
            {
                List<Integer> temp=map.getOrDefault(times[k][1],new  ArrayList<>());
                temp.add(pq.poll());
                map.put(times[k][1],temp);
                k++;
            }
        }
        return pq.peek();
    }
}