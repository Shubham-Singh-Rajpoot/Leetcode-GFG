class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new  ArrayList<>();
        for(char ch='1';ch<='9';ch++)
        {
            String s=""+ch;
            for(char temp=(char)(ch+1);temp<='9';s+=temp,temp++)
            {
                if(Integer.parseInt(s)>high)
                    break;
                if(Integer.parseInt(s)<low)
                    continue;
                list.add(Integer.parseInt(s));
            }
            if(Integer.parseInt(s)>=low && Integer.parseInt(s)<=high)
                list.add(Integer.parseInt(s));
        }
        Collections.sort(list);
        return list;
    }
}