class Solution {
    String ones[]={""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten"," Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
    String tens[]={" Ten"," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
    public String numberToWords(int num)
    {
        if(num==0)
            return "Zero";
        String ans="";
        String adder[]={""," Thousand"," Million"," Billion"};
        int cnt3=0;
        while(num!=0)
        {
            String cal=helper1(num%1000);
            if(cal.length()!=0)
                ans=cal+adder[cnt3]+ans;
            num/=1000;
            cnt3++;
        }
        return ans.trim();
    }
    public String helper1(int num)//<1000
    {
        String ans="";
        if(num>99)
        {
            ans+=ones[num/100]+" Hundred";
            num=num%100;
        }
        if(num>=20)
            ans+=tens[num/10-1]+ones[num%10];
        else
            ans+=ones[num];
        return ans;
    }
}