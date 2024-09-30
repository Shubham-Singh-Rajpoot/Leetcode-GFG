class CustomStack {
    int ar[];
    int index=0;
    public CustomStack(int maxSize) {
        ar=new  int[maxSize];
    }
    public void push(int x)
    {
        if(index<ar.length)
            ar[index++]=x;
    }
    public int pop()
    {
        if(index==0)
            return -1;
        return ar[--index];
    }
    
    public void increment(int k, int val)
    {
        for(int i=0;i<Math.min(k,index);i++)
            ar[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */