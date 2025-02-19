class Solution {
    public String getHappyString(int n, int k)
    {
        ArrayList<String> list=new  ArrayList<>();
        traverse(n,k,"",list);
        if(list.size()<k)
            return "";
        else
            return list.get(k-1);
    }
    public void traverse(int n,int k,String str,ArrayList<String> list)
    {
        if(list.size()==k)
            return;
        if(str.length()==n)
        {
            list.add(str);
            return;
        }
        if(str.length()==0)
        {
            traverse(n,k,"a",list);
            traverse(n,k,"b",list);
            traverse(n,k,"c",list);
        }
        if(str.length()!=0 && str.charAt(str.length()-1)!='a')
            traverse(n,k,str+"a",list);
        if(str.length()!=0 && str.charAt(str.length()-1)!='b')
            traverse(n,k,str+"b",list);
        if(str.length()!=0 && str.charAt(str.length()-1)!='c')
            traverse(n,k,str+"c",list);
    }
}