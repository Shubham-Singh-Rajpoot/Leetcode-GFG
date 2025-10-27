class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int prev=0;
        for(int i=0;i<bank.length;i++)
        {
            if(bank[i].indexOf('1')==-1)
                continue;
            int curr=0;
            for(int j=0;j<bank[i].length();j++)
                if(bank[i].charAt(j)=='1')
                    curr++;
            ans+=(prev*curr);
            prev=curr;
        }
        return ans;
    }
}