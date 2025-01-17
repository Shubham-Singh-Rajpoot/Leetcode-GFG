class Solution {
    public boolean doesValidArrayExist(int[] derived)
    {
        int x=derived[0];
        for(int i=1;i<derived.length;i++)
            x^=derived[i];
        if(x==0)
            return true;
        return false;
    }
}