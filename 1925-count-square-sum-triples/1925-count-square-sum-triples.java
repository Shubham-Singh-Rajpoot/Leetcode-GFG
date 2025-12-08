class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                double num=Math.sqrt(i*i + j*j);
                if(i!=j)
                {
                    for(int k=1;k<=n;k++)
                    {
                        if(k*1.0==num)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}