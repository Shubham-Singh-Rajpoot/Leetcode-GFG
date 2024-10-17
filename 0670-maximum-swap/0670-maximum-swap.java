class Solution {
    public int maximumSwap(int num) {
        int temp=num;
        int len=0;
        while(temp!=0)
        {
            len++;
            temp/=10;
        }
        int ar[]=new int[len];
        temp=num;
        while(temp!=0)
        {
            ar[len-1]=temp%10;
            temp/=10;
            len--;
        }
        int lm[]=new int[ar.length];
        for(int i=0;i<ar.length;i++)
            lm[i]=ar[i];
        for(int i=lm.length-2;i>=0;i--)
            if(lm[i]<lm[i+1])
                lm[i]=lm[i+1];
        for(int i=0;i<ar.length;i++)
        {
            if(lm[i]==ar[i])
                continue;
            else
            {
                int ind;
                for(int j=i;j<ar.length;j++)
                {
                    if(ar[j]==lm[i])
                    {
                        temp=ar[j];
                        ar[j]=ar[i];
                        ar[i]=temp;
                        temp=0;

                        for(int l:ar)
                            temp=temp*10 +l;
                        if(temp>num)
                            num=temp;

                        temp=ar[j];
                        ar[j]=ar[i];
                        ar[i]=temp;
                        temp=0;
                    }
                }
                break;
            }
        }
        return num;
    }
}