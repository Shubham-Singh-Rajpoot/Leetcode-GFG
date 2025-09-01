class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq=new  PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));
        for(int i=0;i<classes.length;i++)
        {
            double ar[]=new  double[3];
            ar[1]=classes[i][0];
            ar[2]=classes[i][1];
            ar[0]=((ar[1]+1)/(ar[2]+1))-ar[1]/ar[2];
            pq.offer(ar);
        }
        for(int i=1;i<=extraStudents;i++)
        {
            double ar[]=pq.poll();
            ar[1]+=1.0;
            ar[2]+=1.0;
            ar[0]=((ar[1]+1)/(ar[2]+1))-ar[1]/ar[2];
            pq.offer(ar);
        }
        double ans=0;
        while(!pq.isEmpty())
        {
            double ar[]=pq.poll();
            ans+=(ar[1]/ar[2]);
        }
        ans/=classes.length;
        return ans;
    }
}