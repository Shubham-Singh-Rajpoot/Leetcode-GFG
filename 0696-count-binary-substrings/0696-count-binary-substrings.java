class Solution {
    public int countBinarySubstrings(String s) 
    {
        // int ans=0;
        // for(int i=0;i<s.length()-1;i++)
        // {
        //     if(s.charAt(i)=='0')
        //     {
        //         int j=i,cnt=0;
        //         while(j<s.length() && s.charAt(j)=='0')
        //         {
        //             j++;
        //             cnt++;
        //         }
        //         while(j<s.length() && s.charAt(j)=='1')
        //         {
        //             j++;
        //             cnt--;
        //         }
        //         if(cnt<=0)
        //             ans++;
        //     }
        //     else
        //     {
        //         int j=i,cnt=0;
        //         while(j<s.length() && s.charAt(j)=='1')
        //         {
        //             j++;
        //             cnt++;
        //         }
        //         while(j<s.length() && s.charAt(j)=='0')
        //         {
        //             j++;
        //             cnt--;
        //         }
        //         if(cnt<=0)
        //             ans++;
        //     }
        // }
        // return ans;
        // int cons0before[]=new  int[s.length()];
        // int cons1before[]=new  int[s.length()];
        // int cons0after[]=new  int[s.length()];
        // int cons1after[]=new  int[s.length()];
        // if(s.charAt(0)=='0')
        // {
        //     cons0before[0]=1;
        //     cons1before[0]=0;
        // }
        // else
        // {
        //     cons0before[0]=0;
        //     cons1before[0]=1;
        // }
        // if(s.charAt(s.length()-1)=='0')
        // {
        //     cons0after[s.length()-1]=1;
        //     cons1after[s.length()-1]=0;
        // }
        // else
        // {
        //     cons0after[s.length()-1]=0;
        //     cons1after[s.length()-1]=1;
        // }
        // for(int i=1;i<s.length();i++)
        // {
        //     if(s.charAt(i)=='0')
        //     {
        //         cons0before[i]=cons0before[i-1]+1;
        //         cons1before[i]=0;
        //     }
        //     else
        //     {
        //         cons1before[i]=cons1before[i-1]+1;
        //         cons0before[i]=0;
        //     }
        // }
        // for(int i=s.length()-2;i>=0;i--)
        // {
        //     if(s.charAt(i)=='0')
        //     {
        //         cons0after[i]=cons0after[i+1]+1;
        //         cons1after[i]=0;
        //     }
        //     else
        //     {
        //         cons1after[i]=cons1after[i+1]+1;
        //         cons0after[i]=0;
        //     }
        // }
        // int ans=0;
        // for(int i=0;i<s.length();i++)
        // {
        //     System.out.println(cons0before[i]+"\t"+cons1before[i]+"\t"+cons0after[i]+"\t"+cons1after[i]);
        // }
        // for(int i=0;i<s.length()-1;i++)
        // {
        //     if((cons0before[i]!=0 && cons0before[i]<=cons1after[i+1]) || (cons1before[i]!=0 && cons1before[i]<=cons0after[i+1]))
        //         ans++;
        // }
        // return ans;
        int res = 0, prev = 0, strk = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) strk++;
            else {
                prev = strk;
                strk = 1;
            }
            if (strk <= prev) res++;
        }
        return res;
    }
}