class Solution
{
    public String shiftingLetters(String s, int[][] shifts)
    {
        char str[]=s.toCharArray();
        int n=s.length();
        int[] prefix=new int[n+1];
        for(int[] num:shifts){
            if(num[2]==0){
                prefix[num[0]]-=1;
                prefix[num[1]+1]+=1;
            }else{
                prefix[num[0]]+=1;
                prefix[num[1]+1]-=1;
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=prefix[i];
            int val=((str[i]-'a')+sum)%26;
            if(val<0) val+=26;
            str[i]=(char)(val+'a');
        }
        return new String(str);
    }
}