class Solution {
    public double myPow(double x, int n)
    {
        return pow(x,n);
    }
    public double pow(double x,long n)
    {
        if(x==1)
            return 1;
        if(n==0)
            return 1;
        else if(n>0)
        {
            double ans=pow(x,n/2);
            if(n%2==1)
                return x*ans*ans;
            else
                return ans*ans;
        }
        else
            return 1/pow(x,Math.abs(n));
    }
}