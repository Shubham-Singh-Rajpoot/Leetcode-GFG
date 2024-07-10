class Solution {
    public int minOperations(String[] logs) {
        int pos=0;
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].equals("../"))
                pos=Math.max(0,pos-1);
            else if(logs[i].equals("./"))
                continue;
            else
                pos+=1;
        }
        return pos;
    }
}