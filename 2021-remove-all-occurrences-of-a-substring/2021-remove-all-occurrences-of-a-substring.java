class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder str=new  StringBuilder(s);
        int index=str.indexOf(part);
        while(index>=0)
        {
            str=str.delete(index,index+part.length());
            index=str.indexOf(part);
        }
        return str.toString();
    }
}