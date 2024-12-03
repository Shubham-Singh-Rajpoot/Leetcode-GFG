class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new  StringBuilder(s);
        for(int i=0;i<spaces.length;i++)
            str=str.replace(spaces[i]+i,spaces[i]+i," ");
        return str.toString();
    }
}