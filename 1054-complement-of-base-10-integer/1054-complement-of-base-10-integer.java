class Solution {
    public int bitwiseComplement(int n) {
        String binary=Integer.toBinaryString(n);
        StringBuilder ans=new  StringBuilder();
        for(int i=0;i<binary.length();i++)
        {
            if(binary.charAt(i)=='1')
                ans.append('0');
            else
                ans.append('1');
        }
        return Integer.parseInt(ans.toString(),2);
    }
}