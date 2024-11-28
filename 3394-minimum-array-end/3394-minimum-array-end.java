class Solution {
    public long minEnd(int n, int x) {
        String sb1=Integer.toBinaryString(x);
        String sb2=Integer.toBinaryString(n-1);

        int i=sb1.length()-1 , j=sb2.length()-1;
        StringBuilder sb=new StringBuilder();

        while(true){
            if(i==-1 && j==-1)
                break;
            else if(i==-1){
                while(j!=-1){
                    sb.insert(0, sb2.charAt(j));
                    j--;
                }
                break;
            }
            else if(j==-1){
                while(i!=-1){
                    sb.insert(0, sb1.charAt(i));
                    i--;
                }
                break;
            }
            else{
                if(sb1.charAt(i)=='1'){
                    sb.insert(0 , sb1.charAt(i));
                    i--;
                }
                else{
                    sb.insert(0, sb2.charAt(j));
                    i--;
                    j--;
                }
            }
        }
        if (sb.length() == 0) {
            return n;
        }
        String s=sb.toString();
        long l= Long.parseLong(s, 2);
        return l;
    }
}