class Pair{
    int capital;
    int profits;
    Pair(int capital,int profits){
        this.capital=capital;
        this.profits=profits;
    }
}
class comp implements Comparator<Pair>{
    public int compare(Pair p,Pair q){
        if(p.capital==q.capital){
            return q.profits-p.profits;
        }
        return p.capital-q.capital;
    }
}
class compforpq implements Comparator<Pair>{
    public int compare(Pair p,Pair q){
        if(p.profits==q.profits){
            return p.capital-q.capital;
        }
        return q.profits-p.profits;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Pair> li=new ArrayList<>();
        for(int i=0;i<capital.length;i++){
            li.add(new Pair(capital[i],profits[i]));
        }
        Collections.sort(li,new comp());
        int inicap=w;
        int i=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>(new compforpq());
        while(k-->0){
            while(i<li.size() && li.get(i).capital<=inicap){
                Pair curr=li.get(i);
                pq.add(new Pair(curr.capital,curr.profits));
                i++;
            }
            if(pq.isEmpty())
                break;
            Pair optimal=pq.poll();
            inicap+=optimal.profits;
        }
        return inicap;
    }
}