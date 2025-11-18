class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length==1)
        {
            if(bits[0]==0)
                return true;
            else
                return false;
        }
        if(bits[bits.length-2]==0)
            return true;
        int cnt=0;
        for(int i=bits.length-2;i>=0;i--)
        {
            if(bits[i]==0)
                break;
            else
                cnt++;
        }
        if(cnt%2==0)
            return true;
        else
            return false;
    }
}